package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRatingUpdateDto {
    private int id;
    private double rating;
}
