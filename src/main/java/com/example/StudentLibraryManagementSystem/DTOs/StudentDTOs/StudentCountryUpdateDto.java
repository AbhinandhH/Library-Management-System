package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentCountryUpdateDto {
    @NotBlank(message = "StudentId should not be empty")
    private int id;
    @NotBlank(message = "country should not be empty")
    private String country;
}
