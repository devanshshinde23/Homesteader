package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Farmer;

public interface FarmerRepo extends JpaRepository<Farmer,Integer>{

	Farmer findByFusernameAndFpassword(String u,String p);
	
	
}
