package com.maciek.utils;

import com.maciek.security.AuthenticatedUser;
import com.maciek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Maciek on 2017-05-11.
 */
@Component
public class AuthenticationContext {

    private UserService userService;

    @Autowired
    public AuthenticationContext(UserService userService){
        this.userService = userService;
    }

    public static Integer getCurrentUsersId() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(principal instanceof AuthenticatedUser){
//            return ((AuthenticatedUser) principal).getId();
//        }
//        return null;
//        return userService.getByEmail(email).getId();
        return 1;
    }
}
