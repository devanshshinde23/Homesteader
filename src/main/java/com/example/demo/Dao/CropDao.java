package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Crop;
import com.example.demo.Model.Farmer;
import com.example.demo.Repo.CropRepo;
import com.example.demo.Repo.FarmerRepo;
import com.example.demo.Service.CropService;

@Service
public class CropDao implements CropService{
	@Autowired 
	CropRepo cr;
	
	@Autowired
	FarmerRepo fr;
	
public void AddCrop(Crop c1, int fid) {
	 Farmer farmer = fr.findById(fid)
             .orElseThrow(() -> new RuntimeException("Farmer not found"));


    c1.setFarmer(farmer);

    cr.save(c1);
	}

 
public List<Crop> getAllCrops()
{ return cr.findAll();
}


public  Crop findById(int cropId) {
	
	return cr.findByCropId(cropId);
}



}

