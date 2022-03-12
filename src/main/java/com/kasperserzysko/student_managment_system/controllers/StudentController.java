package com.kasperserzysko.student_managment_system.controllers;

import com.kasperserzysko.student_managment_system.entities.Student;
import com.kasperserzysko.student_managment_system.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String listStundents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

   @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "create_student";
   }
    @PostMapping("")
   public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student){
        Student existingStudent = studentService.getStudentById(id);

        existingStudent.setId(id);
        updateCheck(student, existingStudent);

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping ("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    private void updateCheck(Student student, Student existingStudent) {
        if (!student.getfName().isEmpty()) {
            existingStudent.setfName(student.getfName());
        }
        if (!student.getlName().isEmpty()) {
            existingStudent.setlName(student.getlName());
        }
        if (!student.getEmail().isEmpty()) {
            existingStudent.setEmail(student.getEmail());
        }
    }
}
