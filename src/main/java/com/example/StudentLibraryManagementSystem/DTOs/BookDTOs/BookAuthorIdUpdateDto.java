package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

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
    @NotNull(message = "authorId should be given")
    private int authorId;
    private int id; //book id that we have to change the current author
}
