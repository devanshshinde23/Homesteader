package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Farmer;
import com.example.demo.Model.Fertilizer;
import com.example.demo.Repo.FarmerRepo;
import com.example.demo.Repo.FertilizerRepo;
import com.example.demo.Service.FertilizerService;

@Service
public class FertilizerDao implements FertilizerService{
	
	@Autowired 
	FertilizerRepo fr;
	
	@Autowired
	FarmerRepo fsr;
	

	@Override
	public void AddFertilizer(Fertilizer f1, Integer farmerId) {
		
		Farmer farmer = fsr.findById(farmerId).orElseThrow(()-> new RuntimeException("Farmer Not Found") );
		
		f1.setFarmer(farmer);
		
		fr.save(f1);
		
	}

}
