package com.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginreg.models.LoginUser;
import com.loginreg.models.User;
import com.loginreg.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
    public String dashboard(HttpSession session, Model model) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        } else {
        model.addAttribute("theUser", userService.findUser((Long)session.getAttribute("user_id")));

        return "Home.jsp";
        }
    }
	
	@GetMapping("/")
    public String index(HttpSession session, Model model) {
        if(session.getAttribute("user_id") != null) {
            return "redirect:/home";
        } else {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
                return "Index.jsp";
        }
    }

   @GetMapping("/register")
   public String register(HttpSession session, Model model) {
	   if(session.getAttribute("user_id") != null) {
		   return "redirect:/home";
	   } else {
		   model.addAttribute("newUser", new User());
		   model.addAttribute("newLogin", new LoginUser());
		   return "Index.jsp";
	   }
   }
    
   @PostMapping("/register")
   public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
       userService.register(newUser, result);
       if(result.hasErrors()) {
           model.addAttribute("newLogin", new LoginUser());
           return "Index.jsp";
       }
       session.setAttribute("user_id", newUser.getId());
       return "redirect:/home";
   }

 // Login User Process
   @PostMapping("/login")
   public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
       User user = userService.login(newLogin, result);
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "Index.jsp";
       }
       session.setAttribute("user_id", user.getId());
       return "redirect:/home";
   }

   // Logout User
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
