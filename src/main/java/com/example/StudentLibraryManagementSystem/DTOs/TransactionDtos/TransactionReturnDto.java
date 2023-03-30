package com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "bookId should not be blank")
    private int bookId;
    @NotBlank(message = "cardId should not be blank")
    private int cardId;
}
