package com.example.StudentLibraryManagementSystem.Model;

import com.example.StudentLibraryManagementSystem.Enums.TransactionStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
    private String transactionId = UUID.randomUUID().toString();
    private LocalDate todayDate = LocalDate.now();
    private LocalDate transactionTime = todayDate; //auto generate
    private LocalDate lastDateOfReturnWithoutFine = transactionTime.plusDays(15); //auto
    private int fine;

    private boolean isIssueOperation;

    @ManyToOne
    @JoinColumn
    private Card card; //One card can make so many transactions. from transaction perspective,
                      // it will be ManyToOne
    @ManyToOne      //for one book there will be many transactions. from transaction perspective,
    @JoinColumn     //it will be ManyToOne
    private Book book;



    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(LocalDate todayDate) {
        this.todayDate = todayDate;
    }

    public void setTransactionTime(LocalDate transactionTime) {
        this.transactionTime = transactionTime;
    }

    public LocalDate getLastDateOfReturnWithoutFine() {
        return lastDateOfReturnWithoutFine;
    }

    public void setLastDateOfReturnWithoutFine(LocalDate lastDateOfReturnWithoutFine) {
        this.lastDateOfReturnWithoutFine = lastDateOfReturnWithoutFine;
    }

    public boolean isIssueOperation() {
        return isIssueOperation;
    }

    public void setIssueOperation(boolean issueOperation) {
        isIssueOperation = issueOperation;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }


    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
