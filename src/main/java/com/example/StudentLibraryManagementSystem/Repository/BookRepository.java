package com.example.StudentLibraryManagementSystem.Repository;

import com.example.StudentLibraryManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
