package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Farmer;
import com.example.demo.Model.Seed;
import com.example.demo.Repo.FarmerRepo;
import com.example.demo.Repo.SeedRepo;
import com.example.demo.Service.SeedService;

@Service
public class SeedDao implements SeedService{

	@Autowired
	SeedRepo sr;
	
	@Autowired
	FarmerRepo fr;
	
	@Override
	public void AddSeed(Seed s1, Integer fid) {
		Farmer farmer = fr.findById(fid).orElseThrow(()-> new RuntimeException("Farmer not found"));
		
	    s1.setFarmer(farmer);
		
	    sr.save(s1);
		
	}

	@Override
	public Object getAllSeeds() {
		
		return sr.findAll();
	}

}
