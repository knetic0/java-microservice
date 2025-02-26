package com.mehmetsolak.userservice.core.result;

import java.util.Map;

public class FailureSuccess<T> extends Result<T> {
    public FailureSuccess() {
        super();
    }

    public FailureSuccess(String message) {
        super(false, message);
    }

    public FailureSuccess(T data) {
        super(false, data);
    }

    public FailureSuccess(String message, T data) {
        super(false, message, data);
    }

    public FailureSuccess(String message, Map<String, String> errors) {
        super(false, message, errors);
    }
}
