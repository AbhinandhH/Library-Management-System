package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

import com.example.StudentLibraryManagementSystem.Enums.Genre;

public class BookAddDto {
    private int pages;
    private double rating;
    private String name;
    private int authorId; //Foreign key. we can pass it directly
    private Genre genre;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
