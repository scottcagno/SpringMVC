package com.cagnosolutions.cei.spring.service;

import java.util.List;
import com.cagnosolutions.cei.spring.domain.User;

public interface UserService {
	public void insert(User user);
	public void update(User user);
	public void delete(User user);
	public List<User> findAll();
	public User findById(Long id);
	public User findByEmail(String email);
	
}
