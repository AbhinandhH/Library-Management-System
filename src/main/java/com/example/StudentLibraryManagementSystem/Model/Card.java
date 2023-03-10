package com.example.StudentLibraryManagementSystem.Model;

import com.example.StudentLibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int cardId;
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    private LocalDate UpdatedOn;
    private LocalDate createdOn = LocalDate.now();//automatic date creation
    private boolean isPending;

    //Student - IdCard Relation
    @OneToOne
    @JoinColumn
    private Student student;


    //Card - Book Relation
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    //card - transaction relation.
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

}
