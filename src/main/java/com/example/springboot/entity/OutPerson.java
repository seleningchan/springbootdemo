package com.example.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "outperson")
@PropertySource(value = "classpath:outperson.properties")
public class OutPerson {
    private String name;
    private Integer age;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
}
