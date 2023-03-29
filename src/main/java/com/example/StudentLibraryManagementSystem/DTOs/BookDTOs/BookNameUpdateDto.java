package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookNameUpdateDto {
    private int id;
    private String name;

}
