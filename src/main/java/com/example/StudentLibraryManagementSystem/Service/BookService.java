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

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    public String addBook(BookAddDto bookAddDto){
       Book book = new Book();
       Author author;
       try{
           author = authorRepository.findById(bookAddDto.getAuthorId()).get();
       }catch(Exception e){
           return "Author not found";
       }
       /*RULE-1 Save all the attributes that programmer should set.
        only after that we have to save*/
       book.setName(bookAddDto.getName());
       book.setIssued(false);
       book.setGenre(bookAddDto.getGenre());
       book.setAuthor(author);
       book.setPages(bookAddDto.getPages());
       book.setRating(bookAddDto.getRating());
       List<Book> currentBooksByAuthor = author.getBooks();
       currentBooksByAuthor.add(book);
       author.setNo_of_books(currentBooksByAuthor.size());
       authorRepository.save(author);
       /* we only need to save the Author into the database.
       Because, Author is the parent of book. Book will automatically add into the
       bookRepository. (Cascading effect)
        */
        return "Book added successfully";
    }

    public String updateBookName(BookNameUpdateDto bookNameUpdateDto){
        Book book;
        try{
            book = bookRepository.findById(bookNameUpdateDto.getId()).get();
        }catch(Exception e){
            return "book not found";
        }
        book.setName(bookNameUpdateDto.getName());
        bookRepository.save(book);
        return "Name updated successfully";
    }

    public String updateBookPages(BookPagesUpdateDto bookPagesUpdateDto){
        Book book;
        try{
            book = bookRepository.findById(bookPagesUpdateDto.getId()).get();
        }catch(Exception e){
            return "book not found";
        }
        book.setPages(bookPagesUpdateDto.getPages());
        bookRepository.save(book);
        return "Pages updated successfully";
    }

    public String updateBookRating(BookRatingUpdateDto bookRatingUpdateDto){
        Book book;
        try{
            book = bookRepository.findById(bookRatingUpdateDto.getId()).get();
        }catch (Exception e){
            return "Book not found";
        }
        book.setRating(bookRatingUpdateDto.getRating());
        bookRepository.save(book);
        return "Rating updated successfully";
    }

    public String updateBookGenre(BookGenreUpdateDto bookGenreUpdateDto){
        Book book;
        try{
            book = bookRepository.findById(bookGenreUpdateDto.getId()).get();
        }catch(Exception e){
            return "Book not found";
        }
        book.setGenre(bookGenreUpdateDto.getGenre());
        bookRepository.save(book);
        return "Genre updated successfully";
    }

    public String updateBookAuthorId(BookAuthorIdUpdateDto bookAuthorIdUpdateDto){
        Book book = bookRepository.findById(bookAuthorIdUpdateDto.getId()).get();
        Author currentAuthor = book.getAuthor();
        List<Book> currentAuthorBooks = currentAuthor.getBooks();
        currentAuthorBooks.remove(book);
        currentAuthor.setNo_of_books(currentAuthorBooks.size());
        currentAuthor.setBooks(currentAuthorBooks);
        Author newAuthor;
        try {
            newAuthor = authorRepository.findById(bookAuthorIdUpdateDto.getAuthorId()).get();
        }catch (Exception e){
            return "The given Author is not found";
        }
        List<Book> newAuthorBooks = newAuthor.getBooks();
        newAuthorBooks.add(book);
        newAuthor.setBooks(newAuthorBooks);
        newAuthor.setNo_of_books(newAuthorBooks.size());
        book.setAuthor(newAuthor);
        return "Author name changed from " + currentAuthor.getName() +" to "+newAuthor.getName();
    }

    public List<String> getTheListOfBooksOfGivenAuthor(int authorId){
        Author author = authorRepository.findById(authorId).get();
        List<Book> books =  author.getBooks();
        List<String> result = new ArrayList<>();
        for(Book book : books){
            result.add(book.getName());
        }
        return result;
    }

    public String deleteTheGivenBook(int bookId){
        Book book = bookRepository.findById(bookId).get();
        Author author = book.getAuthor();
        List<Book> list = author.getBooks();
        list.remove(book);
        author.setBooks(list);
        author.setNo_of_books(list.size());
        bookRepository.delete(book);
        authorRepository.save(author);
        return "Deleted book " + book.getName() + "from database";
    }
}
