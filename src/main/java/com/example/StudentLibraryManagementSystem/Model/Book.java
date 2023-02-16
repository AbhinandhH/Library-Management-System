package com.example.StudentLibraryManagementSystem.Model;

import com.example.StudentLibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    private double rating;
    private boolean issued;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;//default value is set in the constructor

    //book is the child class compared to Author.
    //Setting of foreign key will be in this class only.
    @ManyToOne //from the perspective of books, the relation is many to one. Many books can write by one Author
    @JoinColumn //Join the foreign key with this class
    private Author author;


    //Card - Book relation.
    //Card is parent of book. Because, if there is no card then there is no book can be got issued
    //Many book can issue using only one card
    @ManyToOne
    @JoinColumn
    private Card card;

    public Book() {
        this.genre = Genre.PHILOSOPHY;
        this.rating = 5.0;
        this.card = null;
        this.issued = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public double getRating() {
        return rating;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
