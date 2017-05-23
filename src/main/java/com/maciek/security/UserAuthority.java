package com.maciek.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Maciek on 2017-05-23.
 */
public class UserAuthority implements GrantedAuthority {
    private String authority;

    public UserAuthority() {
    }

    public UserAuthority(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
