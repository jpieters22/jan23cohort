package com.demotwo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "Index.jsp";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "Home.jsp";
	}
}
