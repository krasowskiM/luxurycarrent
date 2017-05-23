package com.maciek.security;

import com.maciek.service.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maciek on 2017-05-22.
 */
class AuthenticationFilter extends GenericFilterBean {
    private TokenAuthenticationService tokenAuthenticationService;

    protected AuthenticationFilter(TokenAuthenticationService tokenAuthenticationService){
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().
                setAuthentication(tokenAuthenticationService.getAuthentication((HttpServletRequest) servletRequest));
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
