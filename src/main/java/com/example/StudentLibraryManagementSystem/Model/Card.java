package com.example.StudentLibraryManagementSystem.Model;

import com.example.StudentLibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
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
    @UpdateTimestamp //automatic timestamping : date will get update when any update came by
    private Date UpdatedOn;
    @CreationTimestamp //automatic timestamping : Create timestamp when object is created
    private Date createdOn;
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
