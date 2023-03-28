package com.wosmart.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("")
	public String index(HttpSession session) {
		session.setAttribute("name", "WOS Mart");
		return "Index.jsp";
	}
	
	@PostMapping("/updateSession")
	public String updateSession(@RequestParam String name, @RequestParam String pet, Model model, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("pet", pet);
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String results() {
		return "Results.jsp";
	}
}
