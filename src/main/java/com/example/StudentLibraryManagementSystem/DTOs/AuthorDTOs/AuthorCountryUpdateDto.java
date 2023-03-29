package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorCountryUpdateDto {
    private int id;
    private String country;
}
