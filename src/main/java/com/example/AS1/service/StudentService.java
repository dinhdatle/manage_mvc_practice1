package com.example.AS1.service;

import com.example.AS1.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
}
