package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AuthorNameUpdateDto {
    private int id;
    private String name;

}
