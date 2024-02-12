package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.api.Student;
import com.example.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/showStudent")
    public String showStudentList(Model model) {
        List<Student> studentList = studentService.loadStudent();
        model.addAttribute("studentList", studentList);
        return "NewFile";
    }

    @GetMapping("/showAddStudentPage")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        if (student.getId() == 0) {
            studentService.saveStudent(student);
        } else {
            studentService.update(student);
        }
        return "redirect:/showStudent";
    }

    @GetMapping("/thankyou")
    public String thankyou() {
        return "Thankyou.. Your record has been added";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("userId") int id, Model model) {
        System.out.println("looking for a student data" + id);
        Student theStudent = studentService.getStudent(id);
        System.out.println(theStudent);
        model.addAttribute("student", theStudent);
        return "add-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("userId") int id) {
        studentService.deleteStudent(id);
        return "redirect:/showStudent";
    }
}
