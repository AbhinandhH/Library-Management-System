package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

public class StudentAddDto {
    /* Actually the id of Student will create automatically. So, user don't want to
    give the id himself. For that,restricting the user from giving the id value by
    using the DTO.
     */
    private String name;
    private int age;
    private String email;
    private String mobNum;
    private String country;

    public StudentAddDto() {
        this.age = 23;
        this.mobNum = "2342342";
        this.country = "INdia";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobNum() {
        return mobNum;
    }

    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
