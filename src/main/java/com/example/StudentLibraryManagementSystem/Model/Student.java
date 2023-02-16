package com.example.StudentLibraryManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
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

    @OneToOne(mappedBy = "studentVariableName",cascade = CascadeType.ALL) //cascading effect will be done by this line
    private Card card; //Entity that has to connect with this class(child)

    public Student() {} //default constructor is mandatory

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


}
