package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentEmailUpdateDto {
    private String email;
    private int id;
}
