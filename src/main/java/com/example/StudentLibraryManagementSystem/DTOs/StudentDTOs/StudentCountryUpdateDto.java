package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentCountryUpdateDto {
    private int id;
    private String country;
}
