package com.maciek.view.request;

/**
 * Created by Maciek on 2017-05-11.
 */
public class LoginRequest {
    private String email;
    private String password;
    private boolean remember;

    public LoginRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRemember() {
        return remember;
    }
}
