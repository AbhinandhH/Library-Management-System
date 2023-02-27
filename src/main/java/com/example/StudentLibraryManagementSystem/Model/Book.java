package com.example.StudentLibraryManagementSystem.Model;

import com.example.StudentLibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "books")
@Setter
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    private double rating = 2.0;
    private boolean issued =  false;
    @Enumerated(value = EnumType.STRING)
    private Genre genre = Genre.FICTIONAL;


    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Card card;

}
