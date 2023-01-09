package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController // indicates that this class will be available through HTTP requests
@RequestMapping("api/v1/students")
@AllArgsConstructor // enable the dependency injection through constructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }
}
