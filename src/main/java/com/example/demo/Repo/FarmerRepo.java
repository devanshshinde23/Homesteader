package com.example.demo.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Farmer;

public interface FarmerRepo extends JpaRepository<Farmer,Integer>{

	Farmer findByFusernameAndFpassword(String u,String p);

	List<Farmer> findByFnameIgnoreCaseContaining(String fname);
	
	List<Farmer> findByFregion(String name);

	Optional<Farmer> findByFid(Long farmerId);
	
	
}
