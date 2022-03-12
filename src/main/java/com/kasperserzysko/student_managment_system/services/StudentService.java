package com.kasperserzysko.student_managment_system.services;

import com.kasperserzysko.student_managment_system.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);
}
