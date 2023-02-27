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
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // Auto generated and auto incrementing variable
    private int id;
    private String name;
    private int age;
    private String country;
    @Column(unique = true) // Only unique emailIds will be there in the rows
    private String email;
    private String phoneNum;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL) //cascading effect will be done by this line
    private Card card; //Entity that has to connect with this class(child)


}
