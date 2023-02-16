package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

public class StudentMobUpdateDto {
    private int id;
    private String mobNum;

    public StudentMobUpdateDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNum() {
        return mobNum;
    }

    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }
}
