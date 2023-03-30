package com.mvccreate.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvccreate.models.Friend;
import com.mvccreate.services.FriendServ;

@Controller
public class HomeController {

	public final FriendServ friendServ;
	
	public HomeController(FriendServ friendServ) {
		this.friendServ = friendServ;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Friend> friends = friendServ.allFriends();
		model.addAttribute("viewFriends", friends);
		return "Index.jsp";
	}
}
