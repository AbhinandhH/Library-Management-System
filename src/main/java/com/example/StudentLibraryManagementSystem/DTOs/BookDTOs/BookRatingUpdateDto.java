package com.example.StudentLibraryManagementSystem.DTOs.BookDTOs;

public class BookRatingUpdateDto {
    private int id;
    private double rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
