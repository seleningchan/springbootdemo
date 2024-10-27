package com.example.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

//•	@Value：只支持基本数据类型的封装，例如字符串、布尔值、整数等类
@Setter
@Getter
@Component
public class PersonByValue {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
}
