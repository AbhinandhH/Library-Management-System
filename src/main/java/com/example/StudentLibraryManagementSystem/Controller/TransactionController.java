package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos.TransactionIssueDto;
import com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos.TransactionReturnDto;
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
    public String issueBook(@RequestBody TransactionIssueDto transactionRequestDto){
        try{
            return transactionService.issueBook(transactionRequestDto);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/return-book")
    public String returnBook(@RequestBody TransactionReturnDto transactionReturnDto){
        try{
            return transactionService.returnBook(transactionReturnDto);
        }catch (Exception e) {
            return e.getMessage();
        }
    }

}
