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
	
	@RequestMapping("/")
	public String indexHandler(@RequestParam(value="msg", required = false) String msg, Model model) {
		model.addAttribute("msg", msg);
		model.addAttribute("user", new User());
		model.addAttribute("userList", userService.findAll());
		return "index";
	}

	@RequestMapping("/addUser")
	public String addUser(@RequestParam(value="confirm", required = true)String confirm, User user, Model model) {
		if (confirm.equals(user.getPass())) {
			userService.insert(user);
			return "redirect:/?msg="+user.getName()+" added successfully.";
		} else {
			return "redirect:/?msg=ERROR";
		}
	}
}
