package com.example.demo.enumpkg;

public enum AppHttpCodeEnum {
    SUCCESS(200,"Successful operation"),
    SYSTEM_ERROR(500,"A Json error occurred"),
    OPERATOR_ERROR(501,"Operator is invalid"),
    VARIABLE_ERROR(502,"Variable is not found"),
    READ_ERROR(503,"A Json read error occurred"),
    WRITE_ERROR(504, "A Json read error occurred")
    ;
    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
