package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos.TransactionIssueDto;
import com.example.StudentLibraryManagementSystem.DTOs.TransactionDtos.TransactionReturnDto;
import com.example.StudentLibraryManagementSystem.Service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book")
    public ResponseEntity<String> issueBook(@RequestBody @Valid TransactionIssueDto transactionRequestDto){
        try{
            return new ResponseEntity<>(transactionService.issueBook(transactionRequestDto), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/return-book")
    public ResponseEntity<String> returnBook(@RequestBody @Valid TransactionReturnDto transactionReturnDto){
        try{
            return new ResponseEntity<>(transactionService.returnBook(transactionReturnDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
