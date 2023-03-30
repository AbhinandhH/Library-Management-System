package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookNameUpdateDto {
    @NotBlank(message = "bookId should be given")
    private int id;
    @NotBlank(message = "new book name should be given")
    private String name;

}
