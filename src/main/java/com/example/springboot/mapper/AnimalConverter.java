package com.example.springboot.mapper;

import com.example.springboot.ApiResult.AnimalRequest;
import com.example.springboot.ApiResult.AnimalResponse;
import com.example.springboot.ApiResult.ZooRequest;
import com.example.springboot.ApiResult.ZooResponse;
import com.example.springboot.entity.Animal;
import com.example.springboot.entity.Zoo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnimalConverter {
    AnimalConverter INSTANCE = Mappers.getMapper(AnimalConverter.class);

    Animal requestToEntity(AnimalRequest zooRequest);

    List<AnimalResponse> entityToResponse(List<Animal> zoos);

    AnimalResponse entityToResponse(Animal zoo);
}
