package com.example.StudentLibraryManagementSystem.Service;

import com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos.TransactionRequestDto;
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

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public String issueBook(TransactionRequestDto transactionRequestDto){
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

        transaction.setTransactionStatus(TransactionStatus.PENDING);
        //if till this time code breaks, it will register with pending status
        transaction.setCard(card);
        transaction.setBook(book);
        transaction.setIssueOperation(true);

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
}
