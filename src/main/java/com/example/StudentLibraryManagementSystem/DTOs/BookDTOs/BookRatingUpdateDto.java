package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRatingUpdateDto {
    @NotBlank(message = "BookId should be given")
    private int id;
    @NotBlank(message = "new rating should be entered")
    private double rating;
}
