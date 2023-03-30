package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBooksFromAuthorDTO {
    @NotBlank(message = "AuthorId should be given")
    private int authorId;
    private List<Integer> listOfBookId = new ArrayList<>();

}
