package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentMobUpdateDto {
    @NotBlank(message = "studentId should not be blank")
    private int id;
    @NotBlank(message = "new mobile number should not be blank")
    @Pattern(regexp = "^\\d{10}$" ,message = "please provide a valid phone number")
    private String mobNum;
}
