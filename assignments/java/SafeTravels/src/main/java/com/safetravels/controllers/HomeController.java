package com.safetravels.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.safetravels.models.Travel;
import com.safetravels.services.TravelServ;

@Controller
public class HomeController {

	@Autowired 
	private TravelServ travelServ;

	@GetMapping("/")
	public String index(@ModelAttribute("travel") Travel travel, Model model) {
		List<Travel> allTravel = travelServ.allTravel();
		model.addAttribute("allTravel", allTravel);
		return "Index.jsp";
	}
	
	@PostMapping("/create")
	public String createTravel(@Valid @ModelAttribute("travel")Travel travel, BindingResult result) {
		travelServ.createItem(travel);
		return "redirect:/";
	}
	
	@GetMapping("/expenses/{id}/show")
	public String viewTravel(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("travel") Travel travel, Model model) {
		model.addAttribute("travel", travelServ.getOne(id));
		return "ShowExpense.jsp";
	}
	
	@GetMapping("/expenses/{id}/edit")
	public String Edit(@PathVariable("id") Long id, Model model) {
		Travel travel = travelServ.getOne(id);
		model.addAttribute("travel", travel);
		return "Edit.jsp";
	}
	
	@PutMapping("/expenses/{id}")
	public String Update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
			return "Edit.jsp";
		} else {
			travelServ.updatedItem(travel);
			return "redirect:/";
		}
	}
	
	@GetMapping("/expenses/{id}/delete")
	public String deleteItem(@PathVariable("id") Long id) {
		travelServ.deleteOne(id);
		return "redirect:/";
	}
}
