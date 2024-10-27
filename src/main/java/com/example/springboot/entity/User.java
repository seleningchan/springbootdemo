package com.example.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class User implements Serializable {
    @Getter
    @Setter
    private static final long serialVersionUID = -3258839839160856613L;
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String passWord;

}