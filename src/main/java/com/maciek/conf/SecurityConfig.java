package com.maciek.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by Maciek on 2017-05-16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/register", "/login").permitAll()
                .antMatchers("/js/**", "/views/**", "/static/**", "/api/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .access("hasRole('USER')")
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable();
//                .and().formLogin().loginPage("/login")
//                .and().logout().permitAll();
//                .and()
//                .formLogin().loginPage("/login")
    }
}
