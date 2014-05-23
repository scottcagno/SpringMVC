package com.cagnosolutions.cei.spring.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.service.UserService;

@Controller
@Scope("request")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String user(Model model, HttpSession session, Principal principal) {
		String email = principal.getName();
		session.setAttribute("email", email);
		model.addAttribute("user", userService.findByEmail(email));
		return "user";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam(value="confirm", required=true) String confirm, User user, HttpSession session) {
		if (confirm.equals(user.getPass()) && user.getPass().length() > 1) {
			userService.update(user);
		}
		return "redirect:/";
	}
}
