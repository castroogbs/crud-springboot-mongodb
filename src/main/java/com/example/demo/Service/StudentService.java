package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repositories.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // enable the dependency injection through constructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        Optional<Student> student = studentRepository.findById(id);
        
        if (student.isPresent()) {
            return student.get();
        }
            
        return null;
    }

    public Student createStudent(Student student) {
        Student s = studentRepository.save(student);
        return s;
    }
    
    public boolean updateStudent(Student student) {
        if (studentRepository.existsById(student.getId())) {
            studentRepository.save(student);
            return true;
        }
        return false;
    }


    public boolean deleteStudent(String id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
