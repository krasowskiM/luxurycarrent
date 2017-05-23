package com.maciek.service;

import com.maciek.persistence.model.User;
import com.maciek.persistence.repo.UserRepository;
import com.maciek.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Maciek on 2017-05-22.
 */
@Service
public class UserAuthenticationService implements UserDetailsService {

    private UserRepository userRepository;

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Autowired
    public UserAuthenticationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public final AuthenticatedUser loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user);
        detailsChecker.check(authenticatedUser);
        return authenticatedUser;
    }
}
