package com.example.StudentLibraryManagementSystem.Service;

import com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs.*;
import com.example.StudentLibraryManagementSystem.Enums.CardStatus;
import com.example.StudentLibraryManagementSystem.Model.Card;
import com.example.StudentLibraryManagementSystem.Model.Student;
import com.example.StudentLibraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(StudentAddDto studentAddDto) throws SQLException,Exception{
        Card card = new Card();

        Student student = new Student();

        student.setName(studentAddDto.getName());
        student.setAge(studentAddDto.getAge());
        student.setCountry(studentAddDto.getCountry());
        student.setEmail(studentAddDto.getEmail());
        student.setPhoneNum(studentAddDto.getMobNum());
        student.setCard(card);

        card.setStudent(student);
        card.setCardStatus(CardStatus.ACTIVATED);
        studentRepository.save(student);
        return "Student Added Successfully";
    }

    public String updateStudentName(StudentNameUpdateDto studentNameUpdateDto) throws NoSuchElementException {
        Student student = studentRepository.findById(studentNameUpdateDto.getId()).get();
        Card card = student.getCard();

        student.setName(studentNameUpdateDto.getName());

        card.setUpdatedOn(LocalDate.now());

        studentRepository.save(student);
        return "Name Updated Successfully";
    }

    public String updateStudentMobileNumber(StudentMobUpdateDto studentMobUpdateDto) throws NoSuchElementException{
        Student student = studentRepository.findById(studentMobUpdateDto.getId()).get();
        Card card = student.getCard();

        card.setUpdatedOn(LocalDate.now());

        student.setPhoneNum(studentMobUpdateDto.getMobNum());

        studentRepository.save(student);
        return "Mobile Number Updated Successfully";
    }

    public String updateStudentEmail(StudentEmailUpdateDto studentEmailUpdateDto) throws NoSuchElementException, SQLException {
        Student student = studentRepository.findById(studentEmailUpdateDto.getId()).get();

        Card card = student.getCard();

        card.setUpdatedOn(LocalDate.now());

        student.setEmail(studentEmailUpdateDto.getEmail());

        studentRepository.save(student);
        return "Email updated successfully";
    }

    public String updateStudentCountry(StudentCountryUpdateDto studentCountryUpdateDto) throws NoSuchElementException{
        Student student = studentRepository.findById(studentCountryUpdateDto.getId()).get();

        Card card  = student.getCard();

        card.setUpdatedOn(LocalDate.now());

        student.setCountry(studentCountryUpdateDto.getCountry());

        studentRepository.save(student);
        return "Country updated successfully";
    }
    public String updateStudentAge(StudentAgeUpdateDto studentAgeUpdateDto) throws NoSuchElementException{
        Student student = studentRepository.findById(studentAgeUpdateDto.getId()).get();

        Card card = student.getCard();

        card.setUpdatedOn(LocalDate.now());

        student.setAge(studentAgeUpdateDto.getAge());

        studentRepository.save(student);
        return "Updated age successfully";
    }

    public String deleteAllStudents(){
        studentRepository.deleteAll();
        return "All students are deleted from the Database";
    }

    public String deleteStudent(Integer studentId) throws NoSuchElementException{
        Student student = studentRepository.findById(studentId).get();

        studentRepository.delete(student);
        return "Student deleted successfully";
    }

}
