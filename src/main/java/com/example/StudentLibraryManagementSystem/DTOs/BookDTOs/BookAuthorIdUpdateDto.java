package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookAuthorIdUpdateDto {
    @NotBlank(message = "authorId should be given")
    private int authorId;
    @NotBlank(message = "bookId should not be empty")
    private int bookId; //book id that we have to change the current author
}
