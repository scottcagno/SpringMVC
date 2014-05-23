package com.cagnosolutions.cei.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("gregpechiro@yahoo.com").password("password").roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    
        	.authorizeRequests()
        		.antMatchers("/static/**", "/adduser").permitAll() 
        		.anyRequest().authenticated()
        		.and()
        	.formLogin()
        		.loginPage("/login")
        		.usernameParameter("email")
        		.passwordParameter("pass")
        		.permitAll()
        		.and()
        	.logout()                                    
        		.permitAll();
    }
}