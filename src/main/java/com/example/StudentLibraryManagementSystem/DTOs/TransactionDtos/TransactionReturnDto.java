package com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionReturnDto {
    private int bookId;
    private int cardId;
}
