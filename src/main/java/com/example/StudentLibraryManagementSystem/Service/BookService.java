package com.example.StudentLibraryManagementSystem.Service;

import com.example.StudentLibraryManagementSystem.DTOs.BookDTOs.*;
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
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    public String addBook(BookAddDto bookAddDto) throws NoSuchElementException {
       Book book = new Book();

       Author author = authorRepository.findById(bookAddDto.getAuthorId()).get();

       List<Book> currentBooksByAuthor = author.getBooks();

       book.setName(bookAddDto.getName());
       book.setAuthor(author);
       book.setPages(bookAddDto.getPages());

       currentBooksByAuthor.add(book);

       author.setNo_of_books(author.getNo_of_books() + 1);

       authorRepository.save(author);

       return "Book added successfully";
    }

    public String updateBookName(BookNameUpdateDto bookNameUpdateDto) throws NoSuchElementException{
        Book book = bookRepository.findById(bookNameUpdateDto.getId()).get();

        book.setName(bookNameUpdateDto.getName());

        bookRepository.save(book);
        return "Name updated successfully";
    }

    public String updateBookPages(BookPagesUpdateDto bookPagesUpdateDto) throws NoSuchElementException{
        Book book = bookRepository.findById(bookPagesUpdateDto.getId()).get();

        book.setPages(bookPagesUpdateDto.getPages());

        bookRepository.save(book);
        return "Pages updated successfully";
    }

    public String updateBookRating(BookRatingUpdateDto bookRatingUpdateDto) throws NoSuchElementException{
        Book    book = bookRepository.findById(bookRatingUpdateDto.getId()).get();

        book.setRating(bookRatingUpdateDto.getRating());

        bookRepository.save(book);
        return "Rating updated successfully";
    }

    public String updateBookGenre(BookGenreUpdateDto bookGenreUpdateDto)throws NoSuchElementException{
        Book    book = bookRepository.findById(bookGenreUpdateDto.getId()).get();

        book.setGenre(bookGenreUpdateDto.getGenre());

        bookRepository.save(book);
        return "Genre updated successfully";
    }

    public String updateBookAuthorId(BookAuthorIdUpdateDto bookAuthorIdUpdateDto) throws NoSuchElementException{
        Book book;
        try{
            book = bookRepository.findById(bookAuthorIdUpdateDto.getId()).get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Book is not found in the database");
        }
        Author oldAuthor = book.getAuthor();
        Author newAuthor;
        try{
            newAuthor = authorRepository.findById(bookAuthorIdUpdateDto.getAuthorId()).get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Author is not found in the database");
        }
        oldAuthor.getBooks().remove(book);
        oldAuthor.setNo_of_books(oldAuthor.getNo_of_books() - 1);
        newAuthor.getBooks().add(book);
        newAuthor.setNo_of_books(newAuthor.getNo_of_books() + 1);
        book.setAuthor(newAuthor);
        authorRepository.save(oldAuthor);
        authorRepository.save(newAuthor);
        return "Author of book '"+book.getName()+"' is changed from '"+oldAuthor.getName()+"' to '"+newAuthor.getName()+"'";
    }

    public List<String> getTheListOfBooksOfGivenAuthor(int authorId) throws NoSuchElementException,Exception{
        Author author = authorRepository.findById(authorId).get();
        List<Book> books =  author.getBooks();
        if(books.size() == 0){
            throw new Exception("author has no books");
        }
        List<String> result = new ArrayList<>();
        for(Book book : books){
            result.add(book.getName());
        }
        return result;
    }
    public List<BookResponseDTO> showListOfBooks() throws Exception{
        List<Book> listOfBooks = bookRepository.findAll();
        if(listOfBooks.size() == 0){
            throw new Exception("No books are there");
        }
        List<BookResponseDTO> returnList = new ArrayList<>();
        for(Book book : listOfBooks){
            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setBookName(book.getName());
            bookResponseDTO.setAuthorName(book.getAuthor().getName());
            bookResponseDTO.setNoOfPages(book.getPages());
            bookResponseDTO.setGenre(book.getGenre());
            bookResponseDTO.setRating(book.getRating());
            returnList.add(bookResponseDTO);
        }
        return returnList;
    }
    public String deleteTheGivenBook(int bookId) throws NoSuchElementException{
        Book book = bookRepository.findById(bookId).get();
        Author author = book.getAuthor();
        author.getBooks().remove(book);
        author.setNo_of_books(author.getNo_of_books() - 1);
        bookRepository.delete(book);
        authorRepository.save(author);
        return "Deleted book " + book.getName() + " from database";
    }
    public String deleteAllBooks(){
        bookRepository.deleteAll();
        return "All books deleted from database";
    }
}
