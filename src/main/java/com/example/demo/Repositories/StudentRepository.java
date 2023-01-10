package com.example.demo.Repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Model.Student;

/**
 * In the generics, the first type is the Student itself and the secong type
 * refers to the Student ID, type. So, it's a String.
 */
public interface StudentRepository extends MongoRepository<Student, String>{
    // here we can add methods using JPQL Queries

    // using Query Methods
    Optional<Student> findStudentByEmail(String email);
}
