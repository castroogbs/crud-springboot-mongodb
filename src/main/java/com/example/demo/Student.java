package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * The data annotation will give us: getters, setters, 
 * constructors, equals, hashCode and others
 */
@Data
@Document // that annotation indicates that this class could be a mongodb document
public class Student {
    @Id // each document should have an id, that makes it unique
    private String id; // this id is auto-generated for us

    private String firstName;
    private String lastName;
    
    /**
     * That way, we will speed up the querys performance when searching by
     * this field
     */
    @Indexed(unique = true)
    private String email;

    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime createdAt;

    public Student(
            String firstName,
            String lastName,
            String email,
            Gender gender,
            Address address,
            List<String> favouriteSubjects,
            BigDecimal totalSpentInBooks,
            LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.createdAt = createdAt;
    }

    

    
}
