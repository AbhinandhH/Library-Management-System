package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorAddDto {
    private String name;
    private int age;
    private String country;

}
