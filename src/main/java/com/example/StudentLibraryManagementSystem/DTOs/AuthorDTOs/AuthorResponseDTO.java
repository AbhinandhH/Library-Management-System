package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDTO {
    private String authorName;
    private String country;
    private int noOfBooks;
    private int age;
}
