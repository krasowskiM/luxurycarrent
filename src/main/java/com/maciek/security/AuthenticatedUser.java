package com.maciek.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maciek.persistence.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maciek on 2017-05-22.
 */
public class AuthenticatedUser implements UserDetails {
    private Integer id;
    private String username;
    private List<UserAuthority> authorities;
    private String password;

    public AuthenticatedUser(){}

    public AuthenticatedUser(List<UserAuthority> authorities) {
        this.authorities = authorities;
    }

    public AuthenticatedUser(User user){
        this.id = user.getId();
        this.username = user.getEmail();
        this.authorities = createGrantedAuthorities(user);
        this.password = user.getPasswordHash();
    }

    @Transactional
    public List<UserAuthority> createGrantedAuthorities(User user) {
        return user.getRoles().stream()
                .map(role -> new UserAuthority(role.getValue())).collect(Collectors.toList());
    }

    @Override
    public List<UserAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(List<UserAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
