package com.example.springboot.service.impl;

import com.example.springboot.ApiResult.ZooRequest;
import com.example.springboot.ApiResult.ZooResponse;
import com.example.springboot.dao.AnimalRepository;
import com.example.springboot.dao.ZooRepository;
import com.example.springboot.entity.Zoo;
import com.example.springboot.mapper.ZooConverter;
import com.example.springboot.service.ZooService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import java.util.Optional;

@Service("zooService")
public class ZooServiceImpl implements ZooService {

    private ZooRepository zooRepository;

    private AnimalRepository animalRepository;

    public ZooServiceImpl(ZooRepository zooRepository, AnimalRepository animalRepository) {
        this.zooRepository = zooRepository;
        this.animalRepository = animalRepository;
    }

    @Transactional
    @Override
    public ZooResponse create(ZooRequest zooRequest) {
        Zoo zoo = ZooConverter.INSTANCE.requestToEntity(zooRequest);
        zooRepository.save(zoo);
        return ZooConverter.INSTANCE.entityToResponse(zoo);
    }

    @Override
    public ZooResponse update(Integer id, ZooRequest zooRequest)  {
        if (zooRepository.findById(id).isPresent()) {
            Zoo zoo = ZooConverter.INSTANCE.requestToEntity(zooRequest);
            zoo.setId(id);
            return ZooConverter.INSTANCE.entityToResponse(zoo);
        } else {
            throw new RuntimeException("no record found id=" + id + " for zoo");
        }
    }

    @Override
    public ZooResponse updateTelephone(Integer id, String telephone){
        Optional<Zoo> optionalZoo = zooRepository.findById(id);
        if (optionalZoo.isPresent()) {
            Zoo zoo = optionalZoo.get();
            zoo.setTelephone(telephone);
            zooRepository.save(zoo);
            return ZooConverter.INSTANCE.entityToResponse(zoo);
        } else {
            throw new RuntimeException ("no record found id=" + id + " for zoo");
        }
    }

    @Override
    public ZooResponse detail(Integer id)  {
        Optional<Zoo> optionalZoo = zooRepository.findById(id);
        if (optionalZoo.isPresent()) {
            return ZooConverter.INSTANCE.entityToResponse(optionalZoo.get());
        } else {
            throw new RuntimeException("no record found id=" + id + " for zoo");
        }
    }

    @Override
    public List<ZooResponse> list() {
        List<Zoo> zoos = zooRepository.findAll();
        return ZooConverter.INSTANCE.entityToResponse(zoos);
    }

    @Transactional
    @Override
    public void delete(Integer id){
        Optional<Zoo> zoo = zooRepository.findById(id);
        if (zoo.isPresent()) {
            zooRepository.deleteById(id);
        } else {
            throw new RuntimeException("no record found id=" + id + " for zoo");
        }
    }
}