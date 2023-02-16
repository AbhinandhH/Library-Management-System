package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

public class StudentNameUpdateDto {
    /* DTO contains only the required attributes to update the student name.
       So that, user cannot manipulate the attributes that should remain the same
       eg:- id.
       Here we are passing the id for fetching the Student that is having this id.
       Not changing the id attribute.(check the StudentService.updateStudentName)
       Because we are carrying only the required attributes, this method of doing is
       lightweight.
       API will get faster.
     */

    private int id;
    private String name;

    public StudentNameUpdateDto() {}

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
}
