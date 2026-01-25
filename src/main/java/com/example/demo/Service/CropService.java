package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Crop;

public interface CropService  {

	public void AddCrop(Crop c1, int fid) ;

	public List<Crop> getAllCrops();

	public  Crop findById(int cropId) ;
	
	
}
