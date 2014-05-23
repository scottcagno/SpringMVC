package com.cagnosolutions.cei.spring.config;

import javax.sql.DataSource;

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
	private DataSource dataSource;
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        	.usersByUsernameQuery("SELECT u.email, u.pass FROM User u WHERE u.email=?")
        	.authoritiesByUsernameQuery("SELECT u.email, u.securityRole FROM User u WHERE u.email=?");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    
        	.authorizeRequests()
        		.antMatchers("/static/**", "/adduser", "/deleteUser").permitAll() 
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