package com.example.wosmartprojc.controllers;

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

import com.example.wosmartprojc.models.Cart;
import com.example.wosmartprojc.models.LoginUser;
import com.example.wosmartprojc.models.User;
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
public class MainController {
	
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
    //      MAIN FUNCTIONS
    // ==========================

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/logReg")
	public String logRed(HttpSession session, Model model) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/dashboard";
		} else {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "logReg.jsp";
		}
		
	}
	
    // ==========================
    //      LOGREG FUNCTIONS
    // ==========================
	
   // Create User Process
   @PostMapping("/register")
   public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
   	userServ.register(newUser, result);
       if(result.hasErrors()) {
           model.addAttribute("newLogin", new LoginUser());
           return "logReg.jsp";
       }
       session.setAttribute("user_id", newUser.getId());
       return "redirect:/dashboard";
   }
	   
   // Login User Process
   @PostMapping("/login")
   public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
       User user = userServ.login(newLogin, result);
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "logReg.jsp";
       }
       session.setAttribute("user_id", user.getId());
       return "redirect:/dashboard";
   }
	   
   // Logout User
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
    // ==========================
    //      PROFILE FUNCTIONS
    // ==========================

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, @ModelAttribute("cart") Cart cart, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/logReg";
		} else {
			model.addAttribute("theUser", userServ.getUser((Long)session.getAttribute("user_id")));
			model.addAttribute("theCart", cartServ.getAll());
			return "dashboard.jsp";
		}
	}
	
	@PostMapping("/addToCart")
	public String addToCart(@Valid @ModelAttribute Cart cart, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "store.jsp";
		} else {
			cartServ.saveOne(cart);
			return "redirect:/dashboard";	
		}
	}
	@GetMapping("/cart/{id}/view")
	public String viewCartItem(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("cart") Cart cart, Model model) {
		if(session.getAttribute("user_id") ==  null) {
			return "redirect:/logReg";
		} else {
			model.addAttribute("theItem", cartServ.getOne(id));
			return "viewCartItem.jsp";
		}
	}
	
	
	
}