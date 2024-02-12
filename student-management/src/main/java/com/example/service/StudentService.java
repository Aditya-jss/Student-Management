package com.example.service;

import java.util.List;

import com.example.api.Student;

public interface StudentService {
    List<Student> loadStudent();
    void saveStudent(Student student);
    Student getStudent(int id);
    void update(Student student);
    void deleteStudent(int id);
}
