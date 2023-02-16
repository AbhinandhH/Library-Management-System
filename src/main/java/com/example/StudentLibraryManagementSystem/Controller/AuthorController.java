package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.AuthorAddDto;
import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.AuthorAgeUpdateDto;
import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.AuthorCountryUpdateDto;
import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.AuthorNameUpdateDto;
import com.example.StudentLibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorAddDto authorAddDto){
        return authorService.addAuthor(authorAddDto);
    }

    @PutMapping("/update-name")
    public String updateAuthorName(@RequestBody AuthorNameUpdateDto authorNameUpdateDto){
        return authorService.updateAuthorName(authorNameUpdateDto);
    }

    @PutMapping("/update-country")
    public String updateAuthorCountry(@RequestBody AuthorCountryUpdateDto authorCountryUpdateDto){
        return authorService.updateAuthorCountry(authorCountryUpdateDto);
    }

    @PutMapping("/update-age")
    public String updateAuthorAge(@RequestBody AuthorAgeUpdateDto authorAgeUpdateDto){
        return authorService.updateAuthorAge(authorAgeUpdateDto);
    }

    @DeleteMapping("/delete-author/{id}")
    public String deleteAuthor(@PathVariable("id") int authorId){
        return authorService.deleteAuthor(authorId);
    }

}
