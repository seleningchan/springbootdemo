package com.example.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "person")
//•	@ConfigurationProperties：支持所有类型数据的封装，如 Map、List、Set以及对象等；
public class Person {
    private String name;
    private Integer age;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

}
