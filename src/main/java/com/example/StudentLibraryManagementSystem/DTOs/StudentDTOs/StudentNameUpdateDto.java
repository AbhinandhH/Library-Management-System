package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentNameUpdateDto {
    @NotBlank(message = "studentId should not be empty")
    private int id;
    @NotBlank(message = "new Name should not be empty")
    private String name;
}
