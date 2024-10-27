package com.example.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Student implements Serializable {
    @Getter
    @Setter
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
}
