package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos.TransactionRequestDto;
import com.example.StudentLibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book")
    public String issueBook(@RequestBody TransactionRequestDto transactionRequestDto){
        try{
            return transactionService.issueBook(transactionRequestDto);
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
