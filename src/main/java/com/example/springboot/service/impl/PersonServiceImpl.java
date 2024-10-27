package com.example.springboot.service.impl;

import com.example.springboot.entity.Person;
import com.example.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    Person person;

    @Override
    public Person getPersonInfo() {
        return person;
    }
}
