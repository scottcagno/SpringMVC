package com.cagnosolutions.cei.spring.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cagnosolutions.cei.spring.domain.User;

@Component
public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	public void save(User user) {
		if(user.getId() == null)
			em.persist(user);
		else 
			em.merge(user);
	}

	public void delete(User user) {
		user = em.merge(user);
		em.remove(user);
	}

	public List<User> findAll() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	public User findOne(Long id) {
		return (User) em.createQuery("SELECT u FROM User u WHERE u.id=:id")
				.setParameter("id", id)
				.getSingleResult();
	}

	public User findByEmail(String email) {
		return (User) em.createQuery("SELECT u FROM User u WHERE u.email=:email")
				.setParameter("email", email)
				.getSingleResult();
	}

}
