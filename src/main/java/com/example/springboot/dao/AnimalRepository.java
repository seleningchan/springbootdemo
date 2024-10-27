package com.example.springboot.dao;

import com.example.springboot.entity.Animal;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AnimalRepository extends ListCrudRepository<Animal, Integer> {

    List<Animal> findAnimalByZooIdIs(Integer zooId);
}
