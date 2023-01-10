package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Contracts.IControllerContract;
import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

import lombok.AllArgsConstructor;

@RestController // indicates that this class will be available through HTTP requests
@RequestMapping("api/v1/students")
@AllArgsConstructor // enable the dependency injection through constructor
public class StudentController implements IControllerContract<Student> {

    private final StudentService studentService;

    @Override
    @GetMapping
    public ResponseEntity<List<Student>> fetchAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchOne(@PathVariable("id") String id) {
        Student student = studentService.getStudentById(id);
        
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(student);
    }

    @Override
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student s = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        if (studentService.updateStudent(student)) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") String id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
