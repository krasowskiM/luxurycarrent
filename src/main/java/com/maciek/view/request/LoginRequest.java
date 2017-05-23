package com.maciek.view.request;

/**
 * Created by Maciek on 2017-05-11.
 */
public class LoginRequest {
    private String username;
    private String password;
    private boolean remember;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password, boolean remember) {
        this.username = username;
        this.password = password;
        this.remember = remember;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRemember() {
        return remember;
    }
}
