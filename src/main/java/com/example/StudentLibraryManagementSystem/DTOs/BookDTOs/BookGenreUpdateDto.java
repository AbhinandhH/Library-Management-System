package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import com.example.StudentLibraryManagementSystem.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookGenreUpdateDto {
    private int id;
    private Genre genre;
}
