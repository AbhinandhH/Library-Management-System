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
       book.setAuthor(author);
       book.setPages(bookAddDto.getPages());
       List<Book> currentBooksByAuthor = author.getBooks();
       currentBooksByAuthor.add(book);
       author.setNo_of_books(author.getNo_of_books() + 1);
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
        int bookId = bookAuthorIdUpdateDto.getId();
        int authorId = bookAuthorIdUpdateDto.getAuthorId();

        Book book;
        try{
            book = bookRepository.findById(bookId).get();
        }catch (Exception e){
            return "book is not found in the database";
        }
        Author oldAuthor = book.getAuthor();
        Author newAuthor;
        try{
            newAuthor = authorRepository.findById(authorId).get();
        }catch (Exception e){
            return "Author not found in the database";
        }

        oldAuthor.getBooks().remove(book);
        oldAuthor.setNo_of_books(oldAuthor.getNo_of_books() - 1);
        newAuthor.getBooks().add(book);
        newAuthor.setNo_of_books(newAuthor.getNo_of_books() + 1);
        book.setAuthor(newAuthor);

        authorRepository.save(oldAuthor);
        authorRepository.save(newAuthor);

        return "Author of book '"+book.getName()+"' is changed from '"+oldAuthor.getName()+"' to '"+newAuthor.getName()+"'";

        //return "Author name changed from " + currentAuthor.getName() +" to "+newAuthor.getName();
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
        return "Deleted book " + book.getName() + " from database";
    }
}
