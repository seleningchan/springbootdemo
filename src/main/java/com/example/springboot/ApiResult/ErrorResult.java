package com.example.springboot.ApiResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult implements Serializable {
    private Integer code;
    private String error;
    private Object detail;
}
