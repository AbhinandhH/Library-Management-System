package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import com.example.StudentLibraryManagementSystem.Enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookGenreUpdateDto {
    @NotBlank(message = "book Id should be given")
    private int id;
    @NotBlank(message = "please provide the genre of the book that is to be get updated")
    private Genre genre;
}
