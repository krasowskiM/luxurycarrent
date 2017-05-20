package com.maciek.service;

import com.maciek.exception.InvalidCredentialsException;
import com.maciek.exception.InvalidPasswordException;
import com.maciek.persistence.model.Role;
import com.maciek.persistence.model.User;
import com.maciek.persistence.repo.RoleRepository;
import com.maciek.persistence.repo.UserRepository;
import com.maciek.view.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Maciek on 2017-05-10.
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Transactional
    public void registerUser(String email, String password) throws InvalidCredentialsException {
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            throw new InvalidCredentialsException();
        } else {
            User user = new User(email, passwordEncoder.encode(password));
            userRepository.save(user);
        }
    }

    @Transactional(readOnly = true)
    public LoginResponse loginUser(String email, String password, boolean isRemembered) throws InvalidCredentialsException, InvalidPasswordException {
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            throw new InvalidCredentialsException();
        } else {
            User user = userRepository.findByEmail(email);
            if(!passwordEncoder.matches(password, user.getPasswordHash())){
                throw new InvalidPasswordException();
            }
            return new LoginResponse("OK");
        }
    }
}
