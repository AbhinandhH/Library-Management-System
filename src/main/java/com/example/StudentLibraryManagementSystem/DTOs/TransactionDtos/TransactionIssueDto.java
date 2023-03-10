package com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TransactionIssueDto {
    private int cardId;
    private int bookId;
}
