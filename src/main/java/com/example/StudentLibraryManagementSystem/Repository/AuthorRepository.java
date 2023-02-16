package com.example.StudentLibraryManagementSystem.Repository;

import com.example.StudentLibraryManagementSystem.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
