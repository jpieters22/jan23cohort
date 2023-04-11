package com.crudreview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudreview.models.Category;
import com.crudreview.services.CategoryServ;
import com.crudreview.services.StickerServ;

@Controller
public class HomeController {

	@Autowired
	private CategoryServ catServ;
	
	@Autowired
	private StickerServ stickerServ;
	
	@GetMapping("/")
	public String index() {
		return "Index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if(session.getAttribute("cat") == null) {
			return "redirect:/";
		}
		return "Dashboard.jsp";
	}
	
	@GetMapping("/addCategory")
	public String addCat(@ModelAttribute("catForm") Category cat) {
		return "AddCat.jsp";
	}
	
	@PostMapping("/createCat")
	public String createCat(@Valid @ModelAttribute("catForm") Category newCat, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "AddCat.jsp";
		} else {
			catServ.createOne(newCat);
			session.setAttribute("cat", newCat.getId());
			return "redirect:/dashboard";
		}
	}
	
}
