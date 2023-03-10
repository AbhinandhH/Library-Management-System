package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookAuthorIdUpdateDto {
    private int authorId;
    private int id; //book id that we have to change the current author
}
