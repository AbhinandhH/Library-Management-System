package com.example.StudentLibraryManagementSystem.Service;

import com.example.StudentLibraryManagementSystem.DTOs.StudentDTOs.*;
import com.example.StudentLibraryManagementSystem.Enums.CardStatus;
import com.example.StudentLibraryManagementSystem.Model.Card;
import com.example.StudentLibraryManagementSystem.Model.Student;
import com.example.StudentLibraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(StudentAddDto studentAddDto){
        Card card = new Card();
        Student student = new Student(); /* we have to change the DTO to Actual
                                            Student object. For that im creating
                                            new object for Student.and setting the
                                            values from the studentDto.*/
        student.setName(studentAddDto.getName());
        student.setAge(studentAddDto.getAge());
        student.setCountry(studentAddDto.getCountry());
        student.setEmail(studentAddDto.getEmail());
        student.setPhoneNum(studentAddDto.getMobNum());
        student.setCard(card);
        card.setStudentVariableName(student); /*setting the student in card to get
                                                foreign key */
        card.setCardStatus(CardStatus.ACTIVATED); /*activating the card when the
                                                    student has been created */
        studentRepository.save(student);
        return "Student Added Successfully";
    }

    public String updateStudentName(StudentNameUpdateDto studentNameUpdateDto){
        Student student;
        try{
            student = studentRepository.findById(studentNameUpdateDto.getId()).get();
        }catch(Exception e){
            return "Student not found";
        }
        student.setName(studentNameUpdateDto.getName());
        studentRepository.save(student);
        return "Name Updated Successfully";
    }

    public String updateStudentMobileNumber(StudentMobUpdateDto studentMobUpdateDto){
        Student student;
        try{
            student = studentRepository.findById(studentMobUpdateDto.getId()).get();
        }catch(Exception e){
            return "Student not found";
        }
        student.setPhoneNum(studentMobUpdateDto.getMobNum());
        studentRepository.save(student);
        return "Mobile Number Updated Successfully";
    }

    public String updateStudentEmail(StudentEmailUpdateDto studentEmailUpdateDto){
        Student student;
        try{
            student = studentRepository.findById(studentEmailUpdateDto.getId()).get();
        }catch(Exception e){
            return "Student not found";
        }
        student.setEmail(studentEmailUpdateDto.getEmail());
        studentRepository.save(student);
        return "Email updated successfully";
    }

    public String updateStudentCountry(StudentCountryUpdateDto studentCountryUpdateDto){
        Student student;

        //if student is not found, there will be a runtime exception.
        try{
            student = studentRepository.findById(studentCountryUpdateDto.getId()).get();
        }catch (Exception e){
            return "Student not found";
        }

        //if given email is already exist, it will throw an exception.
        //email is annotated with unique = true
        try{
            student.setCountry(studentCountryUpdateDto.getCountry());
        }catch(Exception e){
            return "Given email id is already registered";
        }
        student.setCountry(studentCountryUpdateDto.getCountry());
        studentRepository.save(student);
        return "Country updated successfully";
    }
    public String updateStudentAge(StudentAgeUpdateDto studentAgeUpdateDto){
        Student student;
        try{
            student = studentRepository.findById(studentAgeUpdateDto.getId()).get();
        }catch(Exception e){
            return "Student not found";
        }
        student.setAge(studentAgeUpdateDto.getAge());
        studentRepository.save(student);
        return "Updated age successfully";
    }

}
