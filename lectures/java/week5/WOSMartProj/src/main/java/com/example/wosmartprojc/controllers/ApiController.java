package com.example.wosmartprojc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wosmartprojc.models.Food;
import com.example.wosmartprojc.models.Link;
import com.example.wosmartprojc.models.Note;
import com.example.wosmartprojc.models.Puppy;
import com.example.wosmartprojc.models.Squish;
import com.example.wosmartprojc.models.Stick;
import com.example.wosmartprojc.services.FoodServ;
import com.example.wosmartprojc.services.LinkServ;
import com.example.wosmartprojc.services.NoteServ;
import com.example.wosmartprojc.services.PupServ;
import com.example.wosmartprojc.services.SquishServ;
import com.example.wosmartprojc.services.StickServ;

//@CrossOrigin(origins = "http://localhost:8080/api/", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private SquishServ squishServ;
	
	@Autowired
	private FoodServ foodServ;
	
	@Autowired
	private PupServ pupServ;
	
	@Autowired
	private StickServ stickServ;
	
	@Autowired
	private NoteServ noteServ;
	
	@Autowired
	private LinkServ linkServ;
	
	
	// =======================
	//     Get API Root
	// =======================
	
	@GetMapping(path="/", produces="application/json")
	public String apiRoot() {
		return "API Running";
		
	// =======================
	//     Get Squishies
	// =======================
	}
	@GetMapping(path="/squishies", produces="application/json")
	public List<Squish> showSquish() {
		return squishServ.getAll();
	}
	
	// =======================
	//       Get Food
	// =======================
	
	@GetMapping(path="/recipies", produces="application/json")
	public List<Food> showAllFood() {
		return foodServ.getAll();
	}
	
	// =======================
	//       Get Stickers
	// ======================
	
	@GetMapping(path="/stickers", produces="application/json")
	public List<Stick> showAllStick() {
		return stickServ.getAll();
	}

	// =======================
	//      Get Puppies
	// =======================
	
	@GetMapping(path="/puppies", produces="application/json")
	public List<Puppy> showAllPup() {
		return pupServ.getAll();
	}
	
	// =======================
	//      Get Notes
	// =======================
	
	@GetMapping(path="/notes", produces="application/json")
	public List<Note> showAllNote() {
		return noteServ.getAll();
	}
	
	// =======================
	//      Get Links
	// =======================
	
	@GetMapping(path="/links", produces="application/json")
	public List<Link> showAllLink() {
		return linkServ.getAll();
	}
}
