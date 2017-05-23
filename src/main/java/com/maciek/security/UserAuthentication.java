package com.maciek.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by Maciek on 2017-05-22.
 */
public class UserAuthentication implements Authentication {
    private final AuthenticatedUser authenticatedUser;
    private boolean authenticated = true;

    public UserAuthentication(AuthenticatedUser authenticatedUser){
        this.authenticatedUser = authenticatedUser;
    }

    @Override
    public List<UserAuthority> getAuthorities() {
        return authenticatedUser.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return authenticatedUser.getPassword();
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public AuthenticatedUser getPrincipal() {
        return authenticatedUser;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return authenticatedUser.getUsername();
    }
}
