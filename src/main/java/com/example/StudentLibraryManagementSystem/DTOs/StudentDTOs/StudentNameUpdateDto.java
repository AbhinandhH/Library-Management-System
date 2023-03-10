package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentNameUpdateDto {
    private int id;
    private String name;
}
