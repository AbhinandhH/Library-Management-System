package com.example.StudentLibraryManagementSystem.Controller;

import com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs.*;
import com.example.StudentLibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentAddDto student){
        String response = studentService.addStudent(student);
        return response;
    }

    @PutMapping("/update-name")
    public String updateStudentName(@RequestBody StudentNameUpdateDto studentNameUpdateDto){
        return studentService.updateStudentName(studentNameUpdateDto);
    }

    @PutMapping("/update-mobile-number")
    public String updateStudentMobileNumber(@RequestBody StudentMobUpdateDto studentMobUpdateDto){
        return studentService.updateStudentMobileNumber(studentMobUpdateDto);
    }

    @PutMapping("/update-email")
    public String updateStudentEmail(@RequestBody StudentEmailUpdateDto studentEmailUpdateDto){
        return studentService.updateStudentEmail(studentEmailUpdateDto);
    }

    public String updateStudentCountry(@RequestBody StudentCountryUpdateDto studentCountryUpdateDto){
        return studentService.updateStudentCountry(studentCountryUpdateDto);
    }

    public String updateStudentAge(StudentAgeUpdateDto studentAgeUpdateDto){
        return studentService.updateStudentAge(studentAgeUpdateDto);
    }
}
