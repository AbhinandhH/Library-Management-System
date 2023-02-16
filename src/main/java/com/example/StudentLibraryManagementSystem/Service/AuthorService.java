package com.example.StudentLibraryManagementSystem.Service;

import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.AuthorAddDto;
import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.AuthorAgeUpdateDto;
import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.AuthorCountryUpdateDto;
import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.AuthorNameUpdateDto;
import com.example.StudentLibraryManagementSystem.Model.Author;
import com.example.StudentLibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    //adding of author into the database
    public String addAuthor(AuthorAddDto authorAddDto){
        Author author = new Author();
        author.setName(authorAddDto.getName());
        author.setAge(authorAddDto.getAge());
        author.setCountry(authorAddDto.getCountry());
        authorRepository.save(author);
        return "Author added successfully";
    }

    //updating the attributes of author

    public String updateAuthorName(AuthorNameUpdateDto authorNameUpdateDto){
        Author author;
        try{
            author = authorRepository.findById(authorNameUpdateDto.getId()).get();
        }catch(Exception e){
            return "Author is not found";
        }
        author.setName(authorNameUpdateDto.getName());
        authorRepository.save(author);
        return "Name updated successfully";
    }

    public String updateAuthorCountry(AuthorCountryUpdateDto authorCountryUpdateDto){
        Author author;
        try{
            author = authorRepository.findById(authorCountryUpdateDto.getId()).get();
        }catch(Exception e){
            return "Author not found";
        }
        author.setCountry(authorCountryUpdateDto.getCountry());
        authorRepository.save(author);
        return "Country updated successfully";
    }

    public String updateAuthorAge(AuthorAgeUpdateDto authorAgeUpdateDto){
        Author author;
        try{
            author = authorRepository.findById(authorAgeUpdateDto.getId()).get();
        }catch(Exception e){
            return "Author not found";
        }
        author.setAge(authorAgeUpdateDto.getAge());
        authorRepository.save(author);
        return "Age updated Successfully";
    }

    //delete the author using the id

    public String deleteAuthor(int authorId){
        Author author = authorRepository.findById(authorId).get();
        authorRepository.delete(author);
        return "Deleted " + author.getName() + "from the database";
    }

}
