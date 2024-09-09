package com.bd.benu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.benu.model.Counsellor;
import com.bd.benu.model.Dashboard;
import com.bd.benu.repo.CounsellorRepositary;
import com.bd.benu.service.CounsellorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {
	
	@Autowired
	private CounsellorRepositary counsellorRepositary;
	
	@Autowired
	private CounsellorService counsellorService;
	
	@GetMapping(value = {"/","/loadcounsellor"})
	public String loadCounsellor(Model  model) {
		
		Counsellor counsellor = new Counsellor();
		model.addAttribute("counsellor", counsellor);
		return"counsellorRegister";
	}
	
	@PostMapping("/enroll")
	public String counselloerEnroll(@ModelAttribute Counsellor counsellor,Model model) {
		Counsellor counsellorEmail = counsellorService.findByEmail(counsellor.getEmail());
		if(counsellorEmail!=null) {
			model.addAttribute("failMsg", "Email Id is already used.....");
			return "counsellorRegister";
		}
		
		boolean counselloerreg = counsellorService.registerCounsller(counsellor);
		if(counselloerreg) {
			model.addAttribute("sucMsg", "Registr Successfully.....");
		}
		model.addAttribute("failMsg", "Registr Failed.....");
		
		return "counsellorRegister";
	}
	
	@GetMapping(value = {"/login"})
	public String loadLogin(Model  model) {
		
		Counsellor logincounsellorObj = new Counsellor();
		model.addAttribute("logincounsellorObj", logincounsellorObj);
		return"counsellorlogin";
	}
	
	@GetMapping("/dashboard")
	public String loadDashboard(Model model) {
		
		Counsellor counsellor = new Counsellor();
		model.addAttribute("counsellor", counsellor);
		
		return"dashbord";
	}
	
	@PostMapping(value = {"/counsellorlogin"})
	public String loginCheck(@ModelAttribute Counsellor counsellor,HttpServletRequest request, Model  model) {
		Counsellor logincounsellorObj = counsellorService.login(counsellor.getEmail(), counsellor.getPassword());
		if(logincounsellorObj==null) {
			model.addAttribute("errMsg", "invalid credential");
			return "counsellorlogin";
		}else {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("counsellorId", logincounsellorObj.getCounsellorId());
			Dashboard dashboardInfo = counsellorService.getDashboardInfo(logincounsellorObj.getCounsellorId());
			model.addAttribute("dashboardInfo", dashboardInfo);
			return"dashbord";
		}
		
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest httpServletReq) {
		HttpSession session = httpServletReq.getSession();
		session.invalidate();
		return "redirect:/";
	}
	

}
