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
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Session session;
	
	@RequestMapping("/user")
	public String user(Model model) {
		if (session.isLoggedIn()) {
			User user = userService.findById(session.getId());
			model.addAttribute("user", user);
			return "user";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam(value="confirm", required=true) String confirm, User user, Model model) {
		if (confirm.equals(user.getPass())) {
			userService.update(user);
			session.setMessage("Updated Successfully");
		} else {
			session.setMessage("Update unsuccessfull");
		}
		return "redirect:/user";
	}
}