package com.example.springboot.service.impl;

import com.example.springboot.ApiResult.AnimalRequest;
import com.example.springboot.ApiResult.AnimalResponse;
import com.example.springboot.dao.AnimalRepository;
import com.example.springboot.dao.ZooRepository;
import com.example.springboot.entity.Animal;
import com.example.springboot.entity.Zoo;
import com.example.springboot.mapper.AnimalConverter;
import com.example.springboot.service.AnimalService;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {
    private ZooRepository zooRepository;

    private AnimalRepository animalRepository;

    public AnimalServiceImpl(ZooRepository zooRepository, AnimalRepository animalRepository) {
        this.zooRepository = zooRepository;
        this.animalRepository = animalRepository;
    }

    @Override
    public AnimalResponse create(Integer zooId, AnimalRequest animalRequest){
        Optional<Zoo> optionalZoo = zooRepository.findById(zooId);
        if (optionalZoo.isEmpty()) {
            throw new RuntimeException("no record found id=" + zooId + " for zoo");
        }
        Zoo zoo = optionalZoo.get();
        Animal animal = AnimalConverter.INSTANCE.requestToEntity(animalRequest);
        animal.setZoo(zoo);
        animalRepository.save(animal);
        return AnimalConverter.INSTANCE.entityToResponse(animal);
    }

    @Override
    public AnimalResponse detail(Integer id) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            return AnimalConverter.INSTANCE.entityToResponse(optionalAnimal.get());
        } else {
            throw new RuntimeException("no record found id=" + id + " for animal");
        }
    }

    @Override
    public List<AnimalResponse> list() {

        return AnimalConverter.INSTANCE.entityToResponse(animalRepository.findAll());
    }

    @Override
    public List<AnimalResponse> listZooAnimals(Integer zooId) {
        List<Animal> animals = animalRepository.findAnimalByZooIdIs(zooId);
        return AnimalConverter.INSTANCE.entityToResponse(animals);
    }
}
