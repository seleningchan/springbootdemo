package com.example.springboot.dao;

import com.example.springboot.entity.JPAStudent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<JPAStudent, Integer> {
    List<JPAStudent> findByGrade(String grade);
    Optional<JPAStudent> findById(Integer id);
}