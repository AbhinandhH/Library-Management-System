package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookPagesUpdateDto {
    private int id;
    private int pages;
}
