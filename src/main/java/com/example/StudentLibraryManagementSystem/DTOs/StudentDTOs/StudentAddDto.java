package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddDto {
    private String name;
    private int age;
    private String email;
    private String mobNum;
    private String country;
}
