package com.mehmetsolak.userservice.core.result;

public class SuccessResult<T> extends Result<T> {
    public SuccessResult() {
        super();
    }

    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult(String message, T data) {
        super(true, message, data);
    }

    public SuccessResult(T data) {
        super(true, data);
    }
}
