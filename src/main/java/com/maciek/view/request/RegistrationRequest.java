package com.maciek.view.request;

/**
 * Created by Maciek on 2017-05-10.
 */
public class RegistrationRequest {
    private String email;
    private String password;

    public RegistrationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
