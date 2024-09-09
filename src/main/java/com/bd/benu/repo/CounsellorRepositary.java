package com.bd.benu.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.benu.model.Counsellor;



public interface CounsellorRepositary extends JpaRepository<Counsellor, Serializable>{
	
	public Counsellor findByEmailAndPassword(String email, String password);
	
	public  Counsellor findByEmail(String email);

}
