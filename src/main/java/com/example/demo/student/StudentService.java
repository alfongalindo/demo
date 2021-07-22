package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        Optional<Student> studentByEmail =studentRepository.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent()){
            System.out.println("email taken");
        }else{
            studentRepository.save(student);
        }

    }

    public void deleteStudent(Long id) {
        boolean exist = studentRepository.existsById(id);

        if(!exist){
            throw new IllegalStateException("Student:"+id);
        }
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("student not exit"+id));

        if(name != null){
            student.setName(name);
        }

        student.setEmail(email);
    }

    /*public List<Student> getStudents() {
        return Arrays.asList(new Student(1L, "Alfon", "alfongalindo@hotmail.com", LocalDate.of(2000, Month.APRIL, 6), 21));
    }*/
}
