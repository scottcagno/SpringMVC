package com.cagnosolutions.cei.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {

	@RequestMapping("/")
	public String indexHandler(@RequestParam(value="name", required = false, defaultValue = "Joe Schmoe") String name, Model model) {
		model.addAttribute("name", name);
		return "/index";
	}
}
