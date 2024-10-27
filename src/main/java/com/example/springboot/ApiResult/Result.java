package com.example.springboot.ApiResult;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
/*
        code 状态值：由后端统一定义各种返回结果的状态码
        message 描述：本次接口调用的结果描述
        data 数据：本次返回的数据。

        {
        "code":"100",
        "message":"操作成功",
        "data":"hello,SpringBoot"
        }

        */
@Slf4j
public class Result<T> {
    @Getter
    @Setter
    private T data;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private int code;

    public Result(){}
    public Result(String msg, int code){
        this.msg = msg;
        this.code = code;
    }
    public Result(T data, String msg, int code){
        this(msg, code);
        this.data = data;
    }

    public static <T> Result error(int code, String msg){
        return new Result<T>(msg, code);
    }
    public static <T> Result success(T data, int code, String msg){
        log.info("Response data: {}", data);
        return new Result(data, msg, code);
    }
    public static <T> Result success(T data){
        log.info("Response data: {}", data);
        return new Result(data, ResultCode.SUCCESS.getMsg(),ResultCode.SUCCESS.getCode());
    }
































}
