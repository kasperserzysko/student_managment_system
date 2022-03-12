package com.kasperserzysko.student_managment_system.repositories;

import com.kasperserzysko.student_managment_system.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
