package com.example.springboot.dao;

import com.example.springboot.entity.Zoo;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ZooRepository extends ListCrudRepository<Zoo, Integer> {
}
