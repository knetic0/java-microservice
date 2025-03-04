package com.mehmetsolak.userservice.core.result;

import lombok.Data;

import java.util.Map;

@Data
public class Result<T> {
    private boolean success;
    private String message;
    private T data;
    private Map<String, String> errors;

    public Result() {}

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success, T data) {
        this(success);
        this.data = data;
    }

    public Result(boolean success, String message){
        this(success);
        this.message = message;
    }

    public Result(boolean success, String message, T data){
        this(success, message);
        this.data = data;
    }

    public Result(boolean success, String message, Map<String, String> errors){
        this(success, message);
        this.errors = errors;
    }

    public Result(boolean success, String message, T data, Map<String, String> errors){
        this(success, message, errors);
        this.data = data;
    }
}
