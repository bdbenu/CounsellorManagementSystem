package com.bd.benu.service;

import java.util.List;

import com.bd.benu.model.Enquiry;
import com.bd.benu.model.ViewEnqsFilterRequest;

public interface EnquiryService {
	
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception;

	public List<Enquiry> getAllEnquiries(Integer counsellorId);

	public List<Enquiry> getEnquiresWithFilter(ViewEnqsFilterRequest filterReq, Integer counsellorId);

	public Enquiry getEnquriyById(Integer enqId);

}
