package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.BookDTOs.*;
import com.example.StudentLibraryManagementSystem.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody @Valid BookAddDto bookAddDto) {
        try{
            return new ResponseEntity<>(bookService.addBook(bookAddDto), HttpStatus.ACCEPTED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Author not found",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-name")
    public ResponseEntity<String> updateBookName(@RequestBody @Valid BookNameUpdateDto bookNameUpdateDto) {
        try{
            return new ResponseEntity<>(bookService.updateBookName(bookNameUpdateDto),HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>("Book is not found",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-pages")
    public ResponseEntity<String> updateBookPages(@RequestBody @Valid BookPagesUpdateDto bookPagesUpdateDto) {
        try{
            return new ResponseEntity<>(bookService.updateBookPages(bookPagesUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Book is not found",HttpStatus.OK);
        }
    }

    @PutMapping("/update-rating")
    public ResponseEntity<String> updateBookRating(@RequestBody @Valid BookRatingUpdateDto bookRatingUpdateDto){
        try{
            return new ResponseEntity<>(bookService.updateBookRating(bookRatingUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Book is not found",HttpStatus.OK);
        }
    }

    @PutMapping("/update-genre")
    public ResponseEntity<String> updateBookGenre(@RequestBody @Valid BookGenreUpdateDto bookGenreUpdateDto){
        try{
            return new ResponseEntity<>(bookService.updateBookGenre(bookGenreUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Book is not found",HttpStatus.OK);
        }
    }

    @PutMapping("/update-authorId")
    public ResponseEntity<String> updateBookAuthorId(@RequestBody @Valid BookAuthorIdUpdateDto bookAuthorIdUpdateDto){
        try{
            return new ResponseEntity<>(bookService.updateBookAuthorId(bookAuthorIdUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-books-by-author/{id}")
    public ResponseEntity<List<String>> getTheListOfBooksOfGivenAuthor(@PathVariable("id") int authorId){
        try{
            return new ResponseEntity<>(bookService.getTheListOfBooksOfGivenAuthor(authorId),HttpStatus.FOUND);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(List.of("Author not found"),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(List.of(e.getMessage()),HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/get-book-list")
    public ResponseEntity<List<BookResponseDTO>> getListOfBooks(){
        try{
            return new ResponseEntity<>(bookService.showListOfBooks(),HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<String> deleteTheGivenBook(@PathVariable("id") int bookId){
        try{
            return new ResponseEntity<>(bookService.deleteTheGivenBook(bookId),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Book is not found",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
       return new ResponseEntity<>(bookService.deleteAllBooks(), HttpStatus.OK);
    }

}
