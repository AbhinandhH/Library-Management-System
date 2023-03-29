package com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionReturnDto {
    @NotNull(message = "bookId should not be null")
    private int bookId;
    @NotNull(message = "cardId should not be null")
    private int cardId;
}
