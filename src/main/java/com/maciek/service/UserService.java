package com.maciek.service;

import com.maciek.exception.InvalidCredentialsException;
import com.maciek.exception.InvalidPasswordException;
import com.maciek.persistence.model.Role;
import com.maciek.persistence.model.User;
import com.maciek.persistence.repo.RoleRepository;
import com.maciek.persistence.repo.UserRepository;
import com.maciek.utils.AuthenticationContext;
import com.maciek.view.TO.UserTO;
import com.maciek.view.request.LoginRequest;
import com.maciek.view.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciek on 2017-05-10.
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private final int userRoleId = 1;

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
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findOne(userRoleId));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

    @Transactional(readOnly = true)
    public LoginResponse loginUser(LoginRequest loginRequest) throws InvalidCredentialsException, InvalidPasswordException {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        if(email == null || password == null || email.isEmpty() || password.isEmpty()){
            throw new InvalidCredentialsException();
        } else {
            User user = userRepository.findByEmail(email);
            if(user == null){
                throw new UsernameNotFoundException(String.format("No user found with email: %s", email));
            }
            if(!passwordEncoder.matches(password, user.getPasswordHash())){
                throw new InvalidPasswordException();
            }
            return new LoginResponse("OK");
        }
    }

    @Transactional(readOnly = true)
    public UserTO userTO(){
        User user = userRepository.findOne(AuthenticationContext.getCurrentUsersId());
        return new UserTO(user);
    }

    @Transactional
    public void addToUserAccount(BigDecimal amount) {
        User user = userRepository.findOne(AuthenticationContext.getCurrentUsersId());
        user.setFunds(user.getFunds().add(amount));
        userRepository.save(user);
    }
}
