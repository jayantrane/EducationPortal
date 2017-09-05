package com.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.data.User;
import com.spring.web.service.UserService;

@Controller
public class LoginController {
	@Autowired
	 UserService userService;
	
	@RequestMapping("/login")
	public String showlogin(){
		
		return "login";
	}
	

	
/*	@RequestMapping("/j_spring_security_logout")
	public String showloggedoutorig(){
		return "loggedout";
	}
	*/
	@RequestMapping("/createaccount")
	public String createacc(Model model){
		model.addAttribute("user", new User());
		
		return "createaccount";
	}
	
	@RequestMapping(value="/inaccount", method=RequestMethod.POST)
	public String inaccount(Model model , @Valid User user,BindingResult result){
		
		if(result.hasErrors()){
			
			System.out.println("Has errors");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error : errors){
				System.out.println(error.getDefaultMessage());
			}
			
			return "createaccount";
		}else{
		
			System.out.println("Has  no errors");
			 user.enabled =true;
			 user.authority ="user";
			 System.out.println("value set");
				System.out.println(user);
			try{
			 userService.create(user);
			}catch(DuplicateKeyException e){
				result.rejectValue("username", "DuplicateKey.user.username", "Username already exists");
				return "createaccount";
			}
		System.out.println("Has  no errors and created");
		
		return "accountcreated";
		}
	}

}
