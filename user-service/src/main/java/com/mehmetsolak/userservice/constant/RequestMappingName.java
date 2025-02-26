package com.mehmetsolak.userservice.constant;

public class RequestMappingName {
    public static final String USER = "/users";
    public static final String USER_AUTHENTICATION_PREFIX = "/auth";
    public static final String CREATE_USER = USER_AUTHENTICATION_PREFIX + "/create";
    public static final String SIGN_IN_USER = USER_AUTHENTICATION_PREFIX + "/sign-in";
}
