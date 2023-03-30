package com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAgeUpdateDto {

    @NotBlank(message = "New Age should not be blank")
    @Min(value = 6, message = "Age should be greater than or equal to 6")
    @Max(value = 17, message = "Age should be lesser than or equal to 17")
    private int age;
    @NotBlank(message = "StudentId should not be blank")
    private int id;
}
