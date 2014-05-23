package com.cagnosolutions.cei.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.service.UserService;

@Controller
public class SiteController {

	@Autowired
	private UserService userService;

	@RequestMapping("/addUser")
	public String addUser(@RequestParam(value="confirm", required = true)String confirm, User user, Model model) {
		if (confirm.equals(user.getPass()) && user.getPass().length() > 1) {
			userService.insert(user);
			return "redirect:/login";
		} else {
			return "redirect:/login";
		}
	}
}

