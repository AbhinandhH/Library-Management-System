package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorAgeUpdateDto {
    @NotBlank(message = "AuthorId should be given")
    private int id;
    @NotBlank(message = "new age should be given")
    private int age;

}
