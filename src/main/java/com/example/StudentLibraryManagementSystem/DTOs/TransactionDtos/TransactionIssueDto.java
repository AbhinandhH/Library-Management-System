package com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TransactionIssueDto {
    @NotNull(message = "cardId should not be empty")
    private int cardId;
    @NotNull(message = "cardId should not be empty")
    private int bookId;
}
