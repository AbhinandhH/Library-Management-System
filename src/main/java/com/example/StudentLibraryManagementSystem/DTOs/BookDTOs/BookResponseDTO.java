package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import com.example.StudentLibraryManagementSystem.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookResponseDTO {
    private String bookName;
    private int noOfPages;
    private double rating;
    private Genre genre;
    private String authorName;

}
