package com.example.demo.Contracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IControllerContract<T> {
    ResponseEntity<List<T>> fetchAll();
    ResponseEntity<?> fetchOne(String id);
    ResponseEntity<T> create(T obj);
    ResponseEntity<?> update(T obj);
    ResponseEntity<?> remove(String id);
}
