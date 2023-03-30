package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import com.example.StudentLibraryManagementSystem.Enums.Genre;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookAddDto {
    private int pages;
    @Max(value = 5, message = "Must be lesser than or equal to 5")
    @Min(value = 1, message = "Must be greater than or equal to 1")
    private double rating;

    @NotBlank(message = "Name should be given")
    private String name;
    @NotBlank(message = "authorId should be given")
    private int authorId;
    private Genre genre;
}
