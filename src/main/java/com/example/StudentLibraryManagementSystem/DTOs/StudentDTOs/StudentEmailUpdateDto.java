package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentEmailUpdateDto {
    @Email(message = "please provide a valid email address")
    @NotBlank(message = "email address should not be blank")
    private String email;
    @NotBlank(message = "StundentId should not be empty")
    private int id;
}
