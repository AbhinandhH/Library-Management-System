package com.example.StudentLibraryManagementSystem.Service;

import com.example.StudentLibraryManagementSystem.DTOs.AuthorDTOs.*;
import com.example.StudentLibraryManagementSystem.Model.Author;
import com.example.StudentLibraryManagementSystem.Model.Book;
import com.example.StudentLibraryManagementSystem.Repository.AuthorRepository;
import com.example.StudentLibraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public String addAuthor(AuthorAddDto authorAddDto){
        Author author = new Author();
        author.setName(authorAddDto.getName());
        author.setAge(authorAddDto.getAge());
        author.setCountry(authorAddDto.getCountry());
        authorRepository.save(author);
        return "Author added successfully";
    }

    public String updateAuthorName(AuthorNameUpdateDto authorNameUpdateDto) throws NoSuchElementException {
        Author  author = authorRepository.findById(authorNameUpdateDto.getId()).get();
        author.setName(authorNameUpdateDto.getName());
        authorRepository.save(author);
        return "Name updated successfully";
    }

    public String updateAuthorCountry(AuthorCountryUpdateDto authorCountryUpdateDto) throws NoSuchElementException{
        Author author = authorRepository.findById(authorCountryUpdateDto.getId()).get();

        author.setCountry(authorCountryUpdateDto.getCountry());
        authorRepository.save(author);
        return "Country updated successfully";
    }

    public String updateAuthorAge(AuthorAgeUpdateDto authorAgeUpdateDto) throws NoSuchElementException{
        Author author = authorRepository.findById(authorAgeUpdateDto.getId()).get();
        author.setAge(authorAgeUpdateDto.getAge());
        authorRepository.save(author);
        return "Age updated Successfully";
    }
    public List<AuthorResponseDTO> getAuthorList() throws Exception{
        List<Author> listOfAuthors = authorRepository.findAll();
        if(listOfAuthors.size() == 0){
            throw new Exception("there is no authors in the database");
        }
        List<AuthorResponseDTO> returnList = new ArrayList<>();
        for(Author author : listOfAuthors){
            AuthorResponseDTO authorResponseDTO = new AuthorResponseDTO();
            authorResponseDTO.setAuthorName(author.getName());
            authorResponseDTO.setAge(author.getAge());
            authorResponseDTO.setCountry(author.getCountry());
            authorResponseDTO.setNoOfBooks(author.getNo_of_books());
            returnList.add(authorResponseDTO);
        }
        return returnList;
    }
    public String deleteAuthor(int authorId) throws Exception{
        Author author = authorRepository.findById(authorId).get();
        authorRepository.delete(author);
        return "Deleted " + author.getName().toUpperCase() + " from the database";
    }
    public String deleteAllAuthors(){
        authorRepository.deleteAll();
        return "Deleted all authors from the database";
    }

    public String deleteGivenBooksFromGivenAuthor(DeleteBooksFromAuthorDTO deleteBooksFromAuthorDTO) throws NoSuchElementException, NoSuchFieldException{
        Author author = authorRepository.findById(deleteBooksFromAuthorDTO.getAuthorId()).get();

        List<Book> listOfBooksByThisAuthor = author.getBooks();
        List<Integer> listOfBooksToDelete = deleteBooksFromAuthorDTO.getListOfBookId();
        String outputString = "";
        for(Integer id : listOfBooksToDelete){
            Book book;
            try{
                book  = bookRepository.findById(id).get();
            }catch (Exception e){
                throw new NoSuchFieldException("Book not found");
            }

            if(listOfBooksByThisAuthor.contains(book)){
                author.getBooks().remove(book);
                bookRepository.delete(book);
                outputString += book.getName() + " is deleted successfully\n";
            }
            else{
                outputString += book.getName() + " is not written by this Author\n";
            }
        }
        return outputString;
    }

    public List<String> listOfBooksByGivenAuthor(Integer authorId) throws NoSuchElementException,Exception{
        Author author = authorRepository.findById(authorId).get();

        List<Book> listOfBooksByThisAuthor = author.getBooks();
        if(listOfBooksByThisAuthor.size() == 0){
            throw new Exception("Author has no book");
        }
        List<String> bookNames = new ArrayList<>();
        for(Book book : listOfBooksByThisAuthor){
            bookNames.add(book.getName());
        }
        return bookNames;
    }

}
