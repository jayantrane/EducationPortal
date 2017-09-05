package com.jayant.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayant.spring.service.DoctorService;
import com.jayant.spring.service.PatientService;

@Controller("profilecontroller")
public class ProfileController {
	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientService patientService;
	
	@RequestMapping("/profile")
	public String showProfile(Authentication authentication){
		System.out.println(authentication.getName());
		System.out.println("this is checkuser method");

		if(doctorService.checkIfDoctor(authentication.getName())){
			System.out.println("u r doctor");
		}
		else{
			System.out.println("u r patient");
		}
		return "profile";
	}
}
