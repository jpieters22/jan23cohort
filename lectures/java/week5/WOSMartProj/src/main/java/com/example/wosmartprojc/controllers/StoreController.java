package com.example.wosmartprojc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.wosmartprojc.models.Cart;
import com.example.wosmartprojc.services.CartServ;
import com.example.wosmartprojc.services.CategoryServ;
import com.example.wosmartprojc.services.FoodServ;
import com.example.wosmartprojc.services.LinkServ;
import com.example.wosmartprojc.services.NoteServ;
import com.example.wosmartprojc.services.PupServ;
import com.example.wosmartprojc.services.SquishServ;
import com.example.wosmartprojc.services.StickServ;
import com.example.wosmartprojc.services.UserServ;

@Controller
public class StoreController {

	@Autowired
	private CartServ cartServ;
	
	@Autowired
	private CategoryServ categoryServ;
	
	@Autowired
	private FoodServ foodServ;
	
	@Autowired
	private PupServ pupServ;
	
	@Autowired
	private SquishServ squishServ;
	
	@Autowired
	private StickServ stickServ;
	
	@Autowired
	private UserServ userServ;
	
	@Autowired
	private NoteServ noteServ;
	
	@Autowired
	private LinkServ linkServ;
	
	
    // ==========================
    //      MAIN LANDING
    // ==========================
	
	@GetMapping("/store")
	public String wholeStore(HttpSession session, @ModelAttribute("store") Cart cart, Model model) {
		
		model.addAttribute("allFood", foodServ.getAll());
		model.addAttribute("allPup", pupServ.getAll());
		model.addAttribute("allNote", noteServ.getAll());
		model.addAttribute("allLink", linkServ.getAll());
		model.addAttribute("allSquish", squishServ.getAll());
		model.addAttribute("allStick", stickServ.getAll());
		return "store.jsp";
	}
	
	@GetMapping("/store/{dept}")
	public String deptStore(@PathVariable String dept, Model model) {
		if(dept == "food") {
			model.addAttribute("allFood", foodServ.getAll());
		}
		if(dept == "pup") {
			model.addAttribute("allPup", pupServ.getAll());
		}
		if(dept == "note") {
			model.addAttribute("allNote", noteServ.getAll());
		}
		if(dept == "link") {
			model.addAttribute("allLink", linkServ.getAll());
		}
		if(dept == "squish") {
			model.addAttribute("allSquish", squishServ.getAll());
		}
		if(dept == "stick") {
			model.addAttribute("allStick", stickServ.getAll());
		}
		return "deptStore.jsp";
	}
	
	
	
}
