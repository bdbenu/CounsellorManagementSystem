package com.bd.benu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.benu.model.Counsellor;
import com.bd.benu.model.Dashboard;
import com.bd.benu.model.Enquiry;
import com.bd.benu.repo.CounsellorRepositary;
import com.bd.benu.repo.EnquiryRepositary;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private CounsellorRepositary counsellorRepositary;
	
	@Autowired
	private EnquiryRepositary enquiryRepositary;

	@Override
	public boolean registerCounsller(Counsellor counselor) {

		Counsellor savedCounsellor = counsellorRepositary.save(counselor);
		if (savedCounsellor.getCounsellorId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Counsellor> counselles() {
		
		return counsellorRepositary.findAll();
	}

	@Override
	public Counsellor getCounsellerById(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Counsellor login(String email, String pwd) {
		
		Counsellor counsellor = counsellorRepositary.findByEmailAndPassword(email, pwd);
			
		return counsellor;
	}

	@Override
	public Dashboard getDashboardInfo(Integer counsellorId) {
		
		Dashboard dashboard = new Dashboard();
		
		List<Enquiry> enquiryList = enquiryRepositary.getEnquiryByCounsellorId(counsellorId);
		int totalEnquiry = enquiryList.size();
		
		int totalEnroll = enquiryList.stream().filter(e-> e.getStatus().equals("E")).collect(Collectors.toList()).size();
		int openEnquiry = enquiryList.stream().filter(e-> e.getStatus().equals("O")).collect(Collectors.toList()).size();
		int lostEnquiry = enquiryList.stream().filter(e-> e.getStatus().equals("L")).collect(Collectors.toList()).size();
		
		dashboard.setTotalCount(totalEnquiry);
		dashboard.setOpenCount(openEnquiry);
		dashboard.setEnrolleCount(totalEnroll);
		dashboard.setLostCount(lostEnquiry);
		
		return dashboard;
	}

	@Override
	public Counsellor findByEmail(String email) {
		
		return counsellorRepositary.findByEmail(email);
	}

	

}
