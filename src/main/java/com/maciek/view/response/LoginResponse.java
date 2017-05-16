package com.maciek.view.response;

/**
 * Created by Maciek on 2017-05-11.
 */
public class LoginResponse {
    private String status;

    public LoginResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
