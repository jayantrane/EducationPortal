package com.jayant.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayant.spring.data.Report;
import com.jayant.spring.service.DoctorPatientService;
import com.jayant.spring.service.DoctorService;
import com.jayant.spring.service.PatientService;
import com.jayant.spring.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService reportService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientService patientService;
	@Autowired
	DoctorPatientService doctorPatientService;

	@RequestMapping("/report")
	public String showReport(Model model,Authentication authentication){
		if(doctorService.checkIfDoctor(authentication.getName())){
			System.out.println("u r doctor");
			String bol = "true";
			model.addAttribute("isdoctor", bol);
		}
		else{
			System.out.println("u r patient");
			String bol = "false";
			model.addAttribute("isdoctor", bol);
		}
		return "report";
	}

	@RequestMapping("/createreport")
	public String createreport(Model model,Authentication authentication){
		System.out.println(authentication.getName());
		System.out.println(doctorService.getDoctorIdFromUsername(authentication.getName()));
		List<String> patientnames = patientService.getPatientNames(doctorService.getDoctorIdFromUsername(authentication.getName()));
		
		model.addAttribute("patientnames", patientnames);
		model.addAttribute("report", new Report());
		return "createreport";
	}
	
	@RequestMapping("/increatereport")
	public String doreport(Report report , BindingResult result,HttpServletRequest request){
		if(result.hasErrors()){
			List<ObjectError> errors = result.getAllErrors();
			System.out.println("Form not validated");
			for(ObjectError error :errors){
				System.out.println(error);
			}
			return "createreport";
		}else{
			report.setPatient_id(patientService.getPatientIdFromName(request.getParameter("patientname")));
			reportService.createreport(report);
			return "reportadded";
		}
	}
	@RequestMapping("/patients")
	public String showPatients(Model model,Authentication authentication){
		List<String> patientnames = patientService.getPatientNames(doctorService.getDoctorIdFromUsername(authentication.getName()));
		
		model.addAttribute("patientnames", patientnames);
		
		return "patients";
	}
	@RequestMapping("/inpatientreport")
	public String showInPatientReport(HttpServletRequest request,Model model){
		String patientreport = request.getParameter("patientreport");
		int patientid= patientService.getPatientIdFromName(patientreport);
		List<Report> reports = reportService.getReportByPatientId(patientid);
		model.addAttribute("reports",reports);
		return "reports";
	}
	
	@RequestMapping("/myreports")
	public String showMyReports(Authentication authentication,Model model){
		int patientid= patientService.getPatientIdFromUsername(authentication.getName());
		List<Report> myreports = reportService.getReportByPatientId(patientid);
		model.addAttribute("myreports", myreports);
		return "myreports";
	}
	
	
	
}
