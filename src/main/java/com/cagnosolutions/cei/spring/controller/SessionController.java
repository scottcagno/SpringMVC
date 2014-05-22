package com.cagnosolutions.cei.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cagnosolutions.cei.spring.domain.Session;
import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.service.UserService;

@Controller
@Scope("request")
public class SessionController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Session session;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="email", required = true) String email, @RequestParam(value="pass", required=true) String pass, Model model) {
		User user = userService.findByEmail(email);
		if (pass.equals(user.getPass())) {
			session.logIn(user.getId());
			return "redirect:/user";
		} else {
			return "redirect:/?msg=ERROR";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.logout();
		return "redirect:/?msg=Please come again";
	}
}