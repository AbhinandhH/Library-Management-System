package com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos;

public class TransactionIssueDto {
    private int cardId;
    private int bookId;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
