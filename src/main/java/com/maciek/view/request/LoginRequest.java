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

    public LoginRequest(String email, String password, boolean remember) {
        this.email = email;
        this.password = password;
        this.remember = remember;
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
