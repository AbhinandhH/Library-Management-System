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
        Book book;
        try{
            book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        }catch (Exception e){
            return "Book is not found";
        }
        Card card;
        try{
            card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        }catch (Exception e){
            return "Invalid card";
        }
        List<Transaction> cardTransactionList = card.getTransactions();
        int noOfTransactions = cardTransactionList.size();
        Book bookHeLastTaken;
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        //if till this time code breaks, it will register with pending status
        transaction.setCard(card);
        transaction.setBook(book);
        transaction.setIssueOperation(true);

        //if he didn't return the current book he took, then he cant take another book
        if(noOfTransactions > 0){
            bookHeLastTaken = cardTransactionList.get(noOfTransactions - 1).getBook();
            if(bookHeLastTaken.isIssued()){
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transactionRepository.save(transaction);
                return "Already taken a book. He has to return the current book";
            }
        }
        if(book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction); // failed transactions are also saving.
            return "Book is not available right now";
        }
        if(!card.getCardStatus().equals(CardStatus.ACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            return "Card is not eligible for a book issue";
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.getTransactions().add(transaction);
        book.setCard(card);
        card.getBooks().add(book);
        card.getTransactions().add(transaction);

        cardRepository.save(card); //card is the parent of both book and transactions.
        return "Transaction successful";
    }

    public String returnBook(TransactionReturnDto transactionReturnDto){
        Transaction returnTransaction = new Transaction();
        returnTransaction.setIssueOperation(false);
        Book book = bookRepository.findById(transactionReturnDto.getBookId()).get();
        Card card = cardRepository.findById(transactionReturnDto.getCardId()).get();

        List<Transaction> listOfTransactionsOfThisBook = book.getTransactions();
        Transaction lastTransaction = listOfTransactionsOfThisBook.get(listOfTransactionsOfThisBook.size() - 1);

        //checking of fine by using last transaction date details.
        LocalDate returnDate = LocalDate.now();
        LocalDate withoutFineDate = lastTransaction.getLastDateOfReturnWithoutFine();

        if(returnDate.equals(withoutFineDate) || returnDate.isBefore(withoutFineDate)){
            returnTransaction.setFine(0);
        }else{
            long days = ChronoUnit.DAYS.between(withoutFineDate, returnDate);
            returnTransaction.setFine((int) (days * 10));
        }

        book.setIssued(false);
        book.getTransactions().add(returnTransaction);
        card.getTransactions().add(returnTransaction);
        card.getBooks().remove(book);
        card.getTransactions().add(returnTransaction);

        cardRepository.save(card);
        return "Returned the book";
    }
}
