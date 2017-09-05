package com.jayant.spring.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	@RequestMapping("/logout")
	public String showLogout(){
		return "logout";
	}
	@RequestMapping("/checkuser")
	public String checkuser(Model model, Authentication authentication){

		return "checkuser";
	}


}
