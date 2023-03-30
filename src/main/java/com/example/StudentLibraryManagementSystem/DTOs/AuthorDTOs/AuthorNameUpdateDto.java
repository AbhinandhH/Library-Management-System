package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AuthorNameUpdateDto {
    @NotBlank(message = "AuthorId should be given")
    private int id;
    @NotBlank(message = "new name should be given")
    private String name;

}
