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
	
	
	public Farmer getFarmerId(int fid) {
		return fr.findById(fid).orElse(null);
	}
	
	public Farmer saveFarmer(Farmer farmer) {
        return fr.save(farmer);
    }
	@Override
	public Farmer login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Farmer getFarmerDetails(int fid) {
		
		
		return fr.findById(fid).orElseThrow(()-> new RuntimeException("Farmer Not found "));
	}
	@Override
	public List<Farmer> findByFname(String fname) {
		
		return fr.findByFname(fname);
	}
	@Override
	public List<Farmer> fetchData(String name) {
		
		return fr.findByFregion(name);
	}
	
	

}
