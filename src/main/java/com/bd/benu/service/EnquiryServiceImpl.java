package com.bd.benu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bd.benu.model.Counsellor;
import com.bd.benu.model.Enquiry;
import com.bd.benu.model.ViewEnqsFilterRequest;
import com.bd.benu.repo.CounsellorRepositary;
import com.bd.benu.repo.EnquiryRepositary;

import io.micrometer.common.util.StringUtils;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private EnquiryRepositary enquiryRepositary;
	
	@Autowired
	private CounsellorRepositary counsellorRepositary;

	@Override
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception {
		
		Counsellor counsellor = counsellorRepositary.findById(counsellorId).orElse(null);
		if(counsellor == null) {
			throw new Exception("No Counsellor Found");
		}
		
		enq.setCounsellor(counsellor);
		Enquiry savedEnquiry = enquiryRepositary.save(enq);
		
		if(savedEnquiry.getEnquiryId()!=null) {
			
			return true;
		}
		
		return false;
	}

	@Override
	public List<Enquiry> getAllEnquiries(Integer counsellorId) {
		return enquiryRepositary.getEnquiryByCounsellorId(counsellorId);
	}

	@Override
	public List<Enquiry> getEnquiresWithFilter(ViewEnqsFilterRequest filterReq, Integer counsellorId) {
		//Dynamic Query preparation
		//Query by Example
		
		Enquiry entquiry = new Enquiry();
		
		if(StringUtils.isNotEmpty(filterReq.getClassMode())) {
			entquiry.setClassMode(filterReq.getClassMode());
		}
		
		if(StringUtils.isNotEmpty(filterReq.getCourse())) {
			entquiry.setCourse(filterReq.getCourse());
		}
		
		if(StringUtils.isNotEmpty(filterReq.getStatus())) {
			entquiry.setStatus(filterReq.getStatus());
		}
		
		Counsellor counsellor = counsellorRepositary.findById(counsellorId).orElse(null);
		entquiry.setCounsellor(counsellor);
		
		Example<Enquiry> of = Example.of(entquiry);
		
		List<Enquiry> enquiryList = enquiryRepositary.findAll(of);
		
		return enquiryList;
	}

	@Override
	public Enquiry getEnquriyById(Integer enqId) {
		
		return  enquiryRepositary.findById(enqId).orElse(null);
	}

}
