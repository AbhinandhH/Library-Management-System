package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

public class AuthorAddDto {
    private String name;
    private int age;
    private String country;

    public AuthorAddDto(){
        this.name = "Suku";
        this.age = 23;
        this.country = "India";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
