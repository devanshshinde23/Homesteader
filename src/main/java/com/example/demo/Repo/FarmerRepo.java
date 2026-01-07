package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Farmer;

public interface FarmerRepo extends JpaRepository<Farmer,Integer>{

	Farmer findByFusernameAndFpassword(String u,String p);

	List<Farmer> findByFname(String fname);
	
	List<Farmer> findByFregion(String name);
	
	
}
