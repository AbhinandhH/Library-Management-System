package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorAddDto {
    @NotNull(message = "Name should not be empty")
    private String name;
    private int age;
    private String country;

}
