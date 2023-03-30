package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorCountryUpdateDto {
    @NotBlank(message = "AuthorId should be given")
    private int id;
    @NotBlank(message = "new country details should be given")
    private String country;
}
