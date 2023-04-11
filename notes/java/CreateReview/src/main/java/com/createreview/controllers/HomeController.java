package com.createreview.controllers;

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

import com.createreview.models.Item;
import com.createreview.services.ItemService;

@Controller
public class HomeController {

	@Autowired
	private ItemService itemServ;
	
	@GetMapping("/")
	public String index(@ModelAttribute("item") Item item, Model model) {
		model.addAttribute("allItems", itemServ.allItems());
		return "Index.jsp";
	}
	
	//Adding item form
	@GetMapping("/addItem")
	public String addItem(@ModelAttribute("itemForm") Item item) {
		return "AddItem.jsp";
	}
	
	//Creating item
	@PostMapping("/createItem")
	public String createItem(@Valid @ModelAttribute("itemForm") Item newItem, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "AddItem.jsp";
		} else {
			itemServ.createItem(newItem);
			return "redirect:/";
		}
	}
	
	//Edit item page
	@GetMapping("/item/{id}/edit")
	public String editItem(@PathVariable("id") Long id, @ModelAttribute("itemEditForm") Item item, Model model) {
		
		model.addAttribute("item", itemServ.getOne(id));
		
		return "EditItem.jsp";
	}
	
	//Update Item
	@PutMapping("/item/{id}/update")
	public String updateItem(@PathVariable("id") Long id, @Valid @ModelAttribute("itemEditForm") Item item, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "EditItem.jsp";
		} else {
			itemServ.updatedItem(item);
			return "redirect:/";
		}
	}
	
	//delete item
	@GetMapping("/item/{id}/delete")
	public String deleteItem(@PathVariable("id") Long id) {
		itemServ.deleteOne(id);
		return"redirect:/";
	}
	
	
}
