package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Farmer;
import com.example.demo.Repo.FarmerRepo;
import com.example.demo.Service.FarmerService;

@Service
public class FarmerDao implements FarmerService{

	@Autowired
	FarmerRepo fr;
	@Override
	public void register(Farmer f1) {
		
		fr.save(f1);
		
	}
	@Override
	public Farmer CheckFarmerData(String u, String p) {
	
		Farmer fd =fr.findByFusernameAndFpassword(u, p);
		return fd;
	}
	@Override
	public List<Farmer> Display() {
		
		return fr.findAll();
	}

}
