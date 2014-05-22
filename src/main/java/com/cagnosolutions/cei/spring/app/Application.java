package com.cagnosolutions.cei.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.cagnosolutions.cei.spring.config.DataConfig;
import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.service.UserService;

@Configuration
public class Application {

	public static void main(String[] args) {
		
		// initialize application context, and grab service bean
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DataConfig.class);
		UserService service = (UserService) ctx.getBean("userService");

		// create new user objects
		User u1 = new User("Scott Cagno", "scottiecagno@gmail.com");
		User u2 = new User("Kayla Cagno", "kaylacagno@gmail.com");
		User u3 = new User("Greg Pechiro", "gregpechiro@gmail.com");
		User u4 = new User("Rosalie Pechiro", "rosaliepechiro@gmail.com");
		
		// insert users into database
		long startTime = System.currentTimeMillis();
		service.insert(u1);
		service.insert(u2);
		service.insert(u3);
		service.insert(u4);
		long endTime = System.currentTimeMillis();
		System.out.println("inserting took " + (endTime - startTime) + " milliseconds");

		// find all users
		startTime = System.currentTimeMillis();
		Iterable<User> users = service.findAll();
		for(User user : users)
			System.out.println("found " + user);
		endTime = System.currentTimeMillis();
		System.out.println("finding all users took " + (endTime - startTime) + " milliseconds");

	}
}
