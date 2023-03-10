package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.*;
import com.example.StudentLibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorAddDto authorAddDto){
        return new ResponseEntity<>(authorService.addAuthor(authorAddDto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-name")
    public ResponseEntity<String> updateAuthorName(@RequestBody AuthorNameUpdateDto authorNameUpdateDto){
        try{
            return new ResponseEntity<>(authorService.updateAuthorName(authorNameUpdateDto), HttpStatus.ACCEPTED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Author not found in the database",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-country")
    public ResponseEntity<String> updateAuthorCountry(@RequestBody AuthorCountryUpdateDto authorCountryUpdateDto){
        try{
            return new ResponseEntity<>(authorService.updateAuthorCountry(authorCountryUpdateDto),HttpStatus.ACCEPTED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Author not found in the database",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-age")
    public ResponseEntity<String> updateAuthorAge(@RequestBody AuthorAgeUpdateDto authorAgeUpdateDto){
        try{
            return new ResponseEntity<>(authorService.updateAuthorAge(authorAgeUpdateDto),HttpStatus.ACCEPTED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Author not found in the database", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-authors")
    public ResponseEntity<List<AuthorResponseDTO>> getAuhtorList(){
        try{
            return new ResponseEntity<>(authorService.getAuthorList(), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-author/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") int authorId){
        try{
            return new ResponseEntity<>(authorService.deleteAuthor(authorId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Author not found in the database",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-all-authors")
    public String deleteAllAuthors(){
        return authorService.deleteAllAuthors();
    }

    @DeleteMapping("/delete-books-by-given-author")
    public ResponseEntity<String> deleteGivenBooksFromGivenAuthor(@RequestBody DeleteBooksFromAuthorDTO deleteBooksFromAuthorDTO){
        try{
            return new ResponseEntity<>(authorService.deleteGivenBooksFromGivenAuthor(deleteBooksFromAuthorDTO),HttpStatus.GONE);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>("Author not found in the database",HttpStatus.BAD_REQUEST);
        }catch (NoSuchFieldException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-list-of-books-by-given-author/{id}")
    public ResponseEntity<List<String>> listOfBooksByGivenAuthor(@PathVariable("id") Integer authorId){
        try{
            return new ResponseEntity<>(authorService.listOfBooksByGivenAuthor(authorId),HttpStatus.FOUND);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(List.of("Author is not found"),HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(List.of("Author has no books"),HttpStatus.NOT_FOUND);
        }
    }

}
