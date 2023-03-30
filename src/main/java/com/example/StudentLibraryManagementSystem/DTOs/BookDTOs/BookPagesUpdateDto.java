package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookPagesUpdateDto {
    @NotBlank(message = "BookId should be given")
    private int id;
    @NotBlank(message = "new number of pages should be given")
    private int pages;
}
