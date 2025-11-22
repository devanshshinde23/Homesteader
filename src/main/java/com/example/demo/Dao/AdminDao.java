package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.AdminRepo;
import com.example.demo.Model.Admin;
import com.example.demo.Service.AdminService;

@Service
public class AdminDao implements AdminService{

	@Autowired
	AdminRepo ar;

	@Override
	public void Register(Admin a1) {
		
		ar.save(a1);
		
	}

	@Override
	
	public Admin checkAdminData(String u, String p) {
		Admin ad=ar.findByAusernameAndApassword(u, p);
		
		return ad;
	}
	
	
}
