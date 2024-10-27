package com.example.springboot.service;

import com.example.springboot.ApiResult.AnimalRequest;
import com.example.springboot.ApiResult.AnimalResponse;

import java.util.List;

public interface AnimalService {
    AnimalResponse create(Integer zooId, AnimalRequest animalRequest);

    AnimalResponse detail(Integer id);

    List<AnimalResponse> list();

    List<AnimalResponse> listZooAnimals(Integer zooId);
}
