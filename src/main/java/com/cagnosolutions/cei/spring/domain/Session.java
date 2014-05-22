package com.cagnosolutions.cei.spring.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Session {

	private boolean loggedIn;
	private Long id;
	private String message;

	public boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void logIn(Long id) {
		loggedIn = true;
		this.id = id;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public void logout() {
		this.loggedIn = false;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}