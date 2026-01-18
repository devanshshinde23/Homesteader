package com.example.demo.Dao;



import java.util.List;

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
		Agencies ca= ar.findByUsernameAndPassword(u, p);
		return ca;
	}

	@Override
	public Agencies Display() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agencies fetchSingleRecord(String name) {
		Agencies ad=ar.findByName(name);
		
		return ad;
		
	}

	@Override
	public Agencies findByUsername(String x) {
		Agencies ag = ar.findByName(x);
		
		return ag;
	}

	@Override
	public List<Agencies> ADisplay() {
		return ar.findAll();
	}

	@Override
	public Long countAgencies() {
		
		return ar.count();
	}

	@Override
	public List<Agencies> getAllAgencies() {
		
		return ar.findAll();
	}

	public Agencies findById(Long id) 
	{ return ar.findByAid(id).orElse(null); 
	}
	

	

	
}
