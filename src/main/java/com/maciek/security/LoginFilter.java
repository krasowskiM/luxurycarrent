package com.maciek.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maciek.service.TokenAuthenticationService;
import com.maciek.service.UserAuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
class LoginFilter extends AbstractAuthenticationProcessingFilter {

    private TokenAuthenticationService tokenAuthenticationService;
    private UserAuthenticationService userAuthenticationService;

    protected LoginFilter(String urlMapping, TokenAuthenticationService tokenAuthenticationService,
                          UserAuthenticationService userAuthenticationService, AuthenticationManager manager){
        super(new AntPathRequestMatcher(urlMapping));
        this.tokenAuthenticationService = tokenAuthenticationService;
        this.userAuthenticationService = userAuthenticationService;
        setAuthenticationManager(manager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
        AuthenticatedUser user = new ObjectMapper().readValue(httpServletRequest.getInputStream(), AuthenticatedUser.class);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        AuthenticatedUser authenticatedUser = userAuthenticationService.loadUserByUsername(authResult.getName());
        UserAuthentication authentication = new UserAuthentication(authenticatedUser);
        tokenAuthenticationService.addAuthentication(response, authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        SecurityContextHolder.getContext().
//                setAuthentication(tokenAuthenticationService.getAuthentication((HttpServletRequest) req));
//        chain.doFilter(req, res);
//    }
}
