package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentMobUpdateDto {
    private int id;
    private String mobNum;
}
