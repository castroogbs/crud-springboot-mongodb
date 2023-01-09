package com.example.demo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * In the generics, the first type is the Student itself and the secong type
 * refers to the Student ID, type. So, it's a String.
 */
public interface StudentRepository extends MongoRepository<Student, String>{
    // here we can add methods using JPQL Queries

    // using Query Methods
    Optional<Student> findStudentByEmail(String email);
}
