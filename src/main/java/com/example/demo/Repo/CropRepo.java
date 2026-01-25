package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Crop;

public interface CropRepo extends JpaRepository<Crop,Integer>{

	List<Crop> findByFarmerFid(Long farmerId);

	public Crop findByCropId(Integer cropId);
	
}
