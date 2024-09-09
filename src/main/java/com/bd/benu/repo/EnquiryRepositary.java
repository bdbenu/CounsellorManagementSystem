package com.bd.benu.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bd.benu.model.Enquiry;

public interface EnquiryRepositary extends JpaRepository<Enquiry, Serializable>{
	@Query(value = "select * from ENQUIRY_MASTER where counsellor_id=:counsellorId",nativeQuery = true)
	public List<Enquiry> getEnquiryByCounsellorId(Integer counsellorId);

}
