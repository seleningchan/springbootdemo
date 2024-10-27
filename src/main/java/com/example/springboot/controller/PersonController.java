package com.example.springboot.controller;

import com.example.springboot.entity.OutPerson;
import com.example.springboot.entity.Person;
import com.example.springboot.entity.PersonByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    Person person;

    @Autowired
    PersonByValue personByValue;

    @Autowired
    OutPerson outPerson;

    @GetMapping("/helloPerson")
    public Person hello(){
        return person;
    }

    @GetMapping("/hellopersonvalue")
    public PersonByValue hellovalue(){
        return personByValue;
    }

    @GetMapping("/outperson")
    public OutPerson outPerson(){
        return  outPerson;
    }
}
