package com.burgertracker1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.burgertracker1.models.Burger;
import com.burgertracker1.services.BurgerServ;

@Controller
public class HomeController {

	@Autowired
	private BurgerServ burgerServ;
	
	@GetMapping("/")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> allBurgers = burgerServ.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
		return "Index.jsp";
	}
	
	@PostMapping("/create")
	public String createBurger(@Valid @ModelAttribute("burger")Burger burger, BindingResult result) {
		burgerServ.createItem(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burgers/{id}/edit")
	public String Edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerServ.getOne(id);
		model.addAttribute("burger", burger);
		return "Edit.jsp";
	}
	
	@PutMapping("/burgers/{id}")
	public String Update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
			return "Edit.jsp";
		} else {
			burgerServ.updatedItem(burger);
			return "redirect:/";
		}
	}
	
}
