package com.example.springboot.ApiResult;

public enum ResultCode {
    SUCCESS(200, "Success"),
    UNAUTHORIZED(403, "Unauthorized"),
    UNKNOWN_ERROR(10001, "Server side error. Unknown error"),
    PARAMS_NOT_COMPLETE(10002, "Server side error. Params are not complete"),
    PARAMS_TYPE_ERROR(10003, "Server side error. Params type is incorrect."),
    DATA_NOT_FOUND(50001, "Server side error. Data is not found."),
    DATA_IS_WRONG(50002, "Server side error. Data is wrong."),
    DATA_ALREADY_EXISTED(50003, "Server side error. Data is already existed."),
    ADD_DATA_ERROR(50004, "Server side error. Failed to add data."),
    SYSTEM_ERROR(5005, "Server side error. Failed to exception"),
    VALIDATE_ERROR(10004, "Server side error. Param validation error."),
    DATA_EXISTING_ERROR(10062, "Server side error. Data is already existing.");
    private final int code;
    private final String msg;
    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }





























}
