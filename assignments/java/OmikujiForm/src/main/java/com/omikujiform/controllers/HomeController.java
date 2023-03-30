package com.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "Index.jsp";
	}
	
	@RequestMapping("/show")
	public String showFortune(HttpSession session) {
		return "Show.jsp";
	}
	
	@PostMapping("/show")
	public String fortune(@RequestParam Integer fortuneNumber, @RequestParam String city, @RequestParam String name, @RequestParam String hobby, @RequestParam String living, @RequestParam String comment, HttpSession session) {
		session.setAttribute("number", fortuneNumber);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("comment", comment);
		return "redirect:/show";
	}
}
