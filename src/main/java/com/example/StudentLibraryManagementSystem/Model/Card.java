package com.example.StudentLibraryManagementSystem.Model;

import com.example.StudentLibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int cardId;
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    @UpdateTimestamp //automatic timestamping : date will get update when any update came by
    private Date UpdatedOn;
    @CreationTimestamp //automatic timestamping : Create timestamp when object is created
    private Date createdOn;


    //Student - IdCard Relation
    @OneToOne  //One card is belongs to only one student
    @JoinColumn //Join the foreign key column with this child class
    private Student studentVariableName; //Entity(Parent) that have to connect with this class


    //Card - Book Relation
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Book> issuedBooks = new ArrayList<>(); // initializing the list. But, this is not mandatory. Spring boot will automatically initialize this.

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();
    public Card() {
    }

    public List<Book> getBooks() {
        return issuedBooks;
    }

    public void setBooks(List<Book> books) {
        this.issuedBooks = books;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<Book> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Date getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        UpdatedOn = updatedOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
