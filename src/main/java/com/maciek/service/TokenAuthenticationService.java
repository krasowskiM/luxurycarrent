package com.maciek.service;

import com.maciek.security.AuthenticatedUser;
import com.maciek.security.UserAuthentication;
import com.maciek.utils.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

/**
 * Created by Maciek on 2017-05-22.
 */
@Service
public class TokenAuthenticationService {
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
    private final TokenHelper tokenHelper;

    @Autowired
    public TokenAuthenticationService(@Value("${token.secret}") String secret){
        tokenHelper = new TokenHelper(DatatypeConverter.parseBase64Binary(secret));
    }

    public void addAuthentication(HttpServletResponse response, UserAuthentication authentication){
        final AuthenticatedUser user = authentication.getPrincipal();
        response.addHeader(AUTH_HEADER_NAME, tokenHelper.createTokenForUser(user));
    }

    public Authentication getAuthentication(HttpServletRequest request){
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null){
            final AuthenticatedUser user = tokenHelper.parseAuthenticatedUserFromToken(token);
            if(user != null){
                return new UserAuthentication(user);
            }
        }
        return null;
    }
}
