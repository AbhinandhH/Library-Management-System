package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddDto {
    @NotNull(message = "Name should not be empty")
    private String name;
    private int age;
    @NotNull(message = "email should not be empty")
    @Email(message = "Enter a valid email address")
    private String email;
    @NotNull(message = "mobile number should not be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Enter a valid phone number")
    private String mobNum;
    private String country;
}
