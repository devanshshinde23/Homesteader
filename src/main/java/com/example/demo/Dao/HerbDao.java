package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Farmer;
import com.example.demo.Model.Herb;
import com.example.demo.Repo.FarmerRepo;
import com.example.demo.Repo.HerbRepo;
import com.example.demo.Service.HerbService;

@Service
public class HerbDao implements HerbService  {

	@Autowired
	HerbRepo hr;
	
	@Autowired 
	FarmerRepo fr;
	
	@Override
	public void addHerb(Herb h1, Integer fid) {
		
		Farmer farmer =fr.findById(fid).orElseThrow(()-> new RuntimeException("farmer Not Found "));
		
		h1.setFarmer(farmer);
		
		hr.save(h1);
	}

	@Override
	public Object getAllHerbs() {
		
		return hr.findAll();
	}

}
