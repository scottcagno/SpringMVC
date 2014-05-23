package com.cagnosolutions.cei.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.service.UserService;

@Controller
@Scope("request")
public class SessionController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String loginGET(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userList", userService.findAll());
		return "index";
	}
}
