package com.cagnosolutions.cei.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cagnosolutions.cei.spring.domain.User;

@Component
@Service("userService")
public class UserServiceMockImpl implements UserService {
	
	private Map<Long, User> users = new HashMap<Long, User>();
	private Long mockId = 1L;

	public void insert(User user) {
		user.setId(mockId);
		users.put(mockId, user);
		this.mockId++;
	}
	
	public void update(User user) {
		users.put(user.getId(), user);
	}

	
	public void delete(User user) {
		users.remove(user.getId());
	}

	
	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}

	
	public User findById(Long id) {
		return users.get(id);
	}

	
	public User findByEmail(String email) {
		User user = null;
		for (User next : users.values()) {
			if (next.getEmail().equals(email)) {
				user = next;
			}
		}
		return user;
	}
}
