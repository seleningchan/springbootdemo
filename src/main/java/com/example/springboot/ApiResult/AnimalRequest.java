package com.example.springboot.ApiResult;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class AnimalRequest implements Serializable {
    @NotEmpty(message = "animal name not empty")
    @Size(max = 100)
    @Getter
    @Setter
    private String name;
    @NotEmpty
    @Min(value = 1)
    @Getter
    @Setter
    private Integer age;
}