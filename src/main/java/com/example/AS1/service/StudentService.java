package com.example.AS1.service;

import com.example.AS1.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    Student updateStudent(Student student);
}
