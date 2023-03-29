package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs.*;
import com.example.StudentLibraryManagementSystem.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody @Valid StudentAddDto student) {
        try{
            return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.ACCEPTED);
        }catch (SQLException e){
            return new ResponseEntity<>("Email already exists", HttpStatus.IM_USED);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-name")
    public ResponseEntity<String> updateStudentName(@RequestBody StudentNameUpdateDto studentNameUpdateDto) {
        try{
            return new ResponseEntity<>(studentService.updateStudentName(studentNameUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-mobile-number")
    public ResponseEntity<String> updateStudentMobileNumber(@RequestBody StudentMobUpdateDto studentMobUpdateDto){
        try{
            return new ResponseEntity<>(studentService.updateStudentMobileNumber(studentMobUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-email")
    public ResponseEntity<String> updateStudentEmail(@RequestBody StudentEmailUpdateDto studentEmailUpdateDto){
        try{
            return new ResponseEntity<>(studentService.updateStudentEmail(studentEmailUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }catch (SQLException e){
            return new ResponseEntity<>("Email id should be unique", HttpStatus.IM_USED);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update-country")
    public ResponseEntity<String> updateStudentCountry(@RequestBody StudentCountryUpdateDto studentCountryUpdateDto){
        try{
            return new ResponseEntity<>(studentService.updateStudentCountry(studentCountryUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update-age")
    public ResponseEntity<String> updateStudentAge(@RequestBody StudentAgeUpdateDto studentAgeUpdateDto){
        try{
            return new ResponseEntity<>(studentService.updateStudentAge(studentAgeUpdateDto),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-all-students")
    public String deleteAllStudents(){
        return studentService.deleteAllStudents();
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer studentId){
        try{
            return new ResponseEntity<>(studentService.deleteStudent(studentId),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

}
