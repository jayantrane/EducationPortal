package com.jayant.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayant.spring.data.Doctor;
import com.jayant.spring.data.DoctorPatient;
import com.jayant.spring.data.Patient;
import com.jayant.spring.data.User;
import com.jayant.spring.service.DoctorPatientService;
import com.jayant.spring.service.DoctorService;
import com.jayant.spring.service.PatientService;
import com.jayant.spring.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientService patientService;
	@Autowired
	DoctorPatientService doctorPatientService;

	
	@RequestMapping("/users")
	public String showUsers(Model model){
		System.out.println("==In home controller==show users");
		List<User> users = userService.getCurrent();
		model.addAttribute("users", users);
	
		return "users";
	}
	@RequestMapping("/createuser")
	public String createuser(Model model){
		List<String> names = doctorService.getDoctorNames();
		model.addAttribute("names", names);
		model.addAttribute("user",new User());
		return "createuser";
	}
	@RequestMapping("/increateuser")
	public String douser(User user ,BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			System.out.println("Form not validated");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error :errors){
				System.out.println(error);
			}
			return "createuser";
		}
		else{
			
			
			user.setEnabled(true);
			
		if(user.getType().equals("doctor")){
			Doctor doctor = new Doctor();
			doctor.setUsername(user.getUsername());
			doctor.setPassword(user.getPassword());
			doctor.setName(user.getName());
			doctor.setAge(user.getAge());
			user.setAuthority("ROLE_DOCTOR");
			doctorService.createDoctor(doctor);
			
		}
		else{
			Patient patient = new Patient();
			patient.setUsername(user.getUsername());
			patient.setPassword(user.getPassword());
			patient.setName(user.getName());
			patient.setAge(user.getAge());
			patient.setDoctor_id(doctorService.getDoctorIdFromName(request.getParameter("doctorname")));
			user.setAuthority("ROLE_PATIENT");
			patientService.createPatient(patient);
			
			DoctorPatient doctorPatient = new DoctorPatient();
			doctorPatient.setDoctor_id(doctorService.getDoctorIdFromName(request.getParameter("doctorname")));
			System.out.println(patientService.getPatientIdFromName(user.getName()));
			doctorPatient.setPatient_id(patientService.getPatientIdFromName(user.getName()));
			doctorPatientService.createDoctorPatient(doctorPatient);
			
		}
		userService.createUser(user);
		return "useradded";
		}
	}
}
