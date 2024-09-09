package com.bd.benu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bd.benu.model.Enquiry;
import com.bd.benu.model.ViewEnqsFilterRequest;
import com.bd.benu.service.CounsellorService;
import com.bd.benu.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	private static final String Integer = null;

	@Autowired
	private EnquiryService enquiryService;

	@Autowired
	private CounsellorService counsellorService;

	@GetMapping("/enquiry")
	public String loadEnquiry(Model model) {
		Enquiry enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);
		return "enquiry";
	}

	@PostMapping("/addEnquiry")
	public String addEnquiry(@ModelAttribute("enquiry") Enquiry enquiry, HttpServletRequest request, Model model)
			throws Exception {

		// get exsiting session object
		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		boolean addEnquiry = enquiryService.addEnquiry(enquiry, counsellorId);
		if (addEnquiry) {
			model.addAttribute("sucMsg", "Enquiry Added");
		} else {
			model.addAttribute("errMsg", "Enquiry Added failed");

		}

		return "enquiry";
	}

	@GetMapping("/enquirydetails1")
	public String loadEnquiryDetails(Model model) {
		Enquiry enquiries = new Enquiry();
		model.addAttribute("enquiries", enquiries);
		return "enquirydetails";
	}

	@PostMapping("/filterEnq")
	public String filterEnquiryRequest(ViewEnqsFilterRequest viewEnqsFilterRequest, HttpServletRequest request,
			Model model) {

		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		
		List<Enquiry> enquiriesList = enquiryService.getEnquiresWithFilter(viewEnqsFilterRequest, counsellorId);
		model.addAttribute("enquiries", enquiriesList);
		
		ViewEnqsFilterRequest viewenqsfilterrequest = new ViewEnqsFilterRequest();
		model.addAttribute("viewenqsfilterrequest", viewenqsfilterrequest);
		return "enquirydetails";

	}

	@GetMapping("/enquirydetails")
	public String allEnquiry(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		List<Enquiry> enquiries = enquiryService.getAllEnquiries(counsellorId);
		model.addAttribute("enquiries", enquiries);

		ViewEnqsFilterRequest viewenqsfilterrequest = new ViewEnqsFilterRequest();
		model.addAttribute("viewEnqsFilterRequest", viewenqsfilterrequest);
		return "enquirydetails";

	}
	@GetMapping("/editEnquiry")
	public String editEnquiry(@RequestParam("enquiryId") Integer enquiryId,Model model) {
		Enquiry enquiry = enquiryService.getEnquriyById(enquiryId);
		model.addAttribute("enquiry", enquiry);
		
		return "enquiry";
	}

}
