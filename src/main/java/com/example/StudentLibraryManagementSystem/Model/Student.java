package com.example.StudentLibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String country;
    @Column(unique = true)
    private String email;
    private String phoneNum;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;


}
