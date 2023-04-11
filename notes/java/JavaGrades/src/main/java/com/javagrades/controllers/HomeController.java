package com.javagrades.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javagrades.models.Student;
import com.javagrades.services.StudentServ;

@Controller
public class HomeController {

	@Autowired
	private StudentServ studentServ;
	
	//GetMapping - landing page (/)
	@GetMapping("/")
	public String index(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("allStudents", studentServ.getAll());
		return "Index.jsp";
	}
	
	//GetMapping - add student page (/addStudent)
	@GetMapping("/addStudent")
	public String addStudent(@ModelAttribute("studentForm") Student student) {
		return "addStudent.jsp";
	}
	
	//GetMapping - edit student page (/student/{id}/edit)
	
	//PostMapping - createStudent (createStudent)
	@PostMapping("/createStudent")
	public String createStudent(@Valid @ModelAttribute("studentForm") Student newStudent, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "AddStudent.jsp";
		} else {
			studentServ.createOne(newStudent);
			return "redirect:/";
		}
	}
	
	//PutMapping - updateStudent (/student/{id}/update)
	//GetMapping / DeleteMapping - remove Student (/student/{id}/delete)
}
