package com.maciek.security;

import com.maciek.service.TokenAuthenticationService;
import com.maciek.service.UserAuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Maciek on 2017-05-16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserAuthenticationService userAuthenticationService;
    private TokenAuthenticationService tokenAuthenticationService;

    public SecurityConfig(UserAuthenticationService userAuthenticationService,
                          TokenAuthenticationService tokenAuthenticationService){
        super(true);
        this.userAuthenticationService = userAuthenticationService;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().and()
                .anonymous().and()
                .servletApi().and()
                .authorizeRequests()

                .antMatchers("/", "/register", "/login").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/views/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/**").permitAll();
//                .antMatchers("/static/**").permitAll()

//                .anyRequest().hasAnyRole().and()

//                .addFilterBefore(new LoginFilter("/login", tokenAuthenticationService,
//                        userAuthenticationService, authenticationManager()), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new AuthenticationFilter(tokenAuthenticationService),
//                        UsernamePasswordAuthenticationFilter.class)
//                .headers().cacheControl();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAuthenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userAuthenticationService;
    }
}
