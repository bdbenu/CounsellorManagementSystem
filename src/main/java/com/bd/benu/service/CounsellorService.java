package com.bd.benu.service;

import java.util.List;

import com.bd.benu.model.Counsellor;
import com.bd.benu.model.Dashboard;

public interface CounsellorService {
public boolean registerCounsller(Counsellor counselor);
	
	public List<Counsellor> counselles();
	
	public Counsellor getCounsellerById(Integer cid);
	
	public Counsellor login(String email, String pwd);
	
	public Dashboard getDashboardInfo(Integer counsellorId);
	
	public  Counsellor findByEmail(String email);


}
