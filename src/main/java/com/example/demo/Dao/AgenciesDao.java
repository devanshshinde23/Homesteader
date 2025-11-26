package com.example.demo.Dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Agencies;
import com.example.demo.Repo.AgenciesRepo;
import com.example.demo.Service.AgenciesService;

@Service
public class AgenciesDao implements AgenciesService{

	@Autowired
	AgenciesRepo ar;

	@Override
	public void saveAgency(Agencies a1) {
		ar.save(a1);
		
		
	}

	@Override
	public Agencies checkAgency(String u, String p) {
		Agencies ca= ar.findByAusernameAndApassword(u, p);
		return ca;
	}

	

	
}
