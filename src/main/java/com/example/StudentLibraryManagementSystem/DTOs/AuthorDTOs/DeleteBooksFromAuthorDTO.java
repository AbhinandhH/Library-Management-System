package com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs;

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
    private int authorId;
    private List<Integer> listOfBookId = new ArrayList<>();

}
