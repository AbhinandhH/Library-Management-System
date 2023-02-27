package com.example.StudentLibraryManagementSystem.Repository;

import com.example.StudentLibraryManagementSystem.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
