package com.example.springboot.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tb_student")
public class JPAStudent implements Serializable {

    //private ObjectMapper objectMapper = new ObjectMapper();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Integer id;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer sex;
    @Getter
    @Setter
    private Integer age;
    @Getter
    @Setter
    private String grade;

    public JPAStudent(){}

    public JPAStudent(String name, Integer sex, Integer age, String grade){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString(){
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }

















}
