package com.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("")
	public String index(HttpSession session) {
		int count = 0;
		ArrayList<String> activities = new ArrayList<String>();
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", count);
			session.setAttribute("activity", activities);
			System.out.printf("%s from requestmapping\n", count);
		}
		return "Index.jsp";
	}
	
	@PostMapping("/gold/{place}")
	public String gold(HttpSession session, @PathVariable String place, Model model) {
		@SuppressWarnings("unchecked")
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");
		int count = (int) session.getAttribute("count");
		String pattern = "MMM d Y h:m a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		int randNum = 0;
		System.out.printf("%s from post before if, %s time before if\n", count, time);
		if(place.equals("farm")) {
			randNum = 10 + (int)(Math.random() * 10);
			count+= randNum;
//			System.out.printf("%s from post in if\n", count);
			activities.add(0,"\nEntered farm earned " + randNum + " gold. At " + time);
			
		}
		if(place.equals("cave")) {
			randNum = 5 + (int)(Math.random() * 5);
			count+= randNum;
			activities.add(0,"\nEntered cave earned " + randNum + " gold. At " + time);
		}
		if(place.equals("house")) {
			randNum = 2 + (int)(Math.random() * 3);
			count+= randNum;
			activities.add(0,"\nEntered house earned " + randNum + " gold. At " + time);
		}
		if(place.equals("quest")) {
			randNum = 50 - (int)(Math.random() * 100);
			count+= randNum;
			if(randNum < 0) {
				activities.add(0,"\nEntered house lost " + -randNum + " gold. At " + time);
			} else {
			activities.add(0,"\nEntered house earned " + randNum + " gold. At " + time);
			}
		}
		session.setAttribute("activity", activities);
		session.setAttribute("count", count);
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
