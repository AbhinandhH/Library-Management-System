package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.BookDTOs.*;
import com.example.StudentLibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookAddDto bookAddDto) {
        return bookService.addBook(bookAddDto);
    }

    @PutMapping("/update-name")
    public String updateBookName(@RequestBody BookNameUpdateDto bookNameUpdateDto) {
        return bookService.updateBookName(bookNameUpdateDto);
    }

    @PutMapping("/update-pages")
    public String updateBookPages(@RequestBody BookPagesUpdateDto bookPagesUpdateDto) {
        return bookService.updateBookPages(bookPagesUpdateDto);
    }

    @PutMapping("/update-rating")
    public String updateBookRating(@RequestBody BookRatingUpdateDto bookRatingUpdateDto){
        return bookService.updateBookRating(bookRatingUpdateDto);
    }

    @PutMapping("/update-genre")
    public String updateBookGenre(@RequestBody BookGenreUpdateDto bookGenreUpdateDto){
        return bookService.updateBookGenre(bookGenreUpdateDto);
    }

    @PutMapping("/update-authorid")
    public String updateBookAuthorId(@RequestBody BookAuthorIdUpdateDto bookAuthorIdUpdateDto){
        return bookService.updateBookAuthorId(bookAuthorIdUpdateDto);
    }

    @GetMapping("/get-books-by-author/{id}")
    public List<String> getTheListOfBooksOfGivenAuthor(@PathVariable("id") int authorId){
        return bookService.getTheListOfBooksOfGivenAuthor(authorId);
    }

    @DeleteMapping("/delete-book/{id}")
    public String deleteTheGivenBook(@PathVariable("id") int bookId){
        return bookService.deleteTheGivenBook(bookId);
    }

}
