package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

public class BookAuthorIdUpdateDto {
    private int authorId;
    private int id; //book id that we have to change the current author

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
