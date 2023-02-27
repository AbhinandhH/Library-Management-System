package com.example.StudentLibraryManagementSystem.Service;

import com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos.TransactionIssueDto;
import com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos.TransactionReturnDto;
import com.example.StudentLibraryManagementSystem.Enums.CardStatus;
import com.example.StudentLibraryManagementSystem.Enums.TransactionStatus;
import com.example.StudentLibraryManagementSystem.Model.Book;
import com.example.StudentLibraryManagementSystem.Model.Card;
import com.example.StudentLibraryManagementSystem.Model.Transaction;
import com.example.StudentLibraryManagementSystem.Repository.BookRepository;
import com.example.StudentLibraryManagementSystem.Repository.CardRepository;
import com.example.StudentLibraryManagementSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public String issueBook(TransactionIssueDto transactionRequestDto){
        Transaction transaction = new Transaction();
        transaction.setIssueOperation(true);
        Book book;
        try{
            book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        }catch(Exception e){
            return "book is not found";
        }
        Card card;
        try{
            card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        }catch (Exception e){
            return "card is not found";
        }


        transaction.setBook(book);
        transaction.setCard(card);


        if(!card.getCardStatus().equals(CardStatus.ACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setLastDateOfReturnWithoutFine(null);
            transactionRepository.save(transaction);
            return "Card is not eligible for taking books";
        }
        if(book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setLastDateOfReturnWithoutFine(null);
            transactionRepository.save(transaction);
            return "book is not available right now";
        }
        if(card.isPending()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setLastDateOfReturnWithoutFine(null);
            transactionRepository.save(transaction);
            return "current book is not returned";
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        card.getTransactions().add(transaction);
        card.getBooks().add(book);
        card.setPending(true);

        book.setIssued(true);
        book.getTransactions().add(transaction);
        book.setCard(card);

        cardRepository.save(card);
        bookRepository.save(book);
        return "book issued successfully";
    }

    public String returnBook(TransactionReturnDto transactionReturnDto){
        Transaction transaction = new Transaction();
        transaction.setIssueOperation(false);

        Book book;
        try{
            book = bookRepository.findById(transactionReturnDto.getBookId()).get();
        }catch (Exception e){
            return "invalid book";
        }
        Card card;
        try{
            card = cardRepository.findById(transactionReturnDto.getCardId()).get();
        }catch(Exception e){
            return "invalid card";
        }

        transaction.setCard(card);
        transaction.setBook(book);

        List<Book> booksTakenByThisCard = card.getBooks();
        Book lastTakenBook = null;


        if(!card.isPending() || booksTakenByThisCard.size() == 0 || card.getTransactions().size() == 0){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setLastDateOfReturnWithoutFine(null);
            transactionRepository.save(transaction);
            return "Nothing to return by this card";
        }
        lastTakenBook = booksTakenByThisCard.get(booksTakenByThisCard.size() - 1);
        if(!lastTakenBook.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setLastDateOfReturnWithoutFine(null);
            transactionRepository.save(transaction);
            return "nothing to return by this card";
        }
        if(lastTakenBook.isIssued() && !lastTakenBook.equals(book)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setLastDateOfReturnWithoutFine(null);
            transactionRepository.save(transaction);
            return "returning book and taken book are different";
        }

        //fine calculation
        List<Transaction> issueTransactionsByThisCard = card.getTransactions();
        Transaction lastTransaction = issueTransactionsByThisCard.get(issueTransactionsByThisCard.size() - 1);
        LocalDate returnDate = LocalDate.now();
        LocalDate withoutFineDate = lastTransaction.getLastDateOfReturnWithoutFine();
        int fine = 0;
        if(returnDate.isAfter(withoutFineDate)){
            long days = ChronoUnit.DAYS.between(withoutFineDate, returnDate);
            fine = (int) days * 10;
        }

        transaction.setFine(fine);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setLastDateOfReturnWithoutFine(null);

        card.setPending(false);
        card.getBooks().remove(book);

        book.setIssued(false);
        book.setCard(null);
        transactionRepository.save(transaction);
        cardRepository.save(card);
        bookRepository.save(book);
        return "Returned successfully";
    }
}
