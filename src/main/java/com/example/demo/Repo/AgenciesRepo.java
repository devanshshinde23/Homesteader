package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Agencies;

public interface AgenciesRepo extends JpaRepository<Agencies,Integer>{

	Agencies findByUsernameAndPassword(String u, String p);
	
	Agencies findByName(String u);
	
	List<Agencies> findByStatus(String status); 
	
	List<Agencies> findByType(String type);
	
	List<Agencies> findByVillage(String village); // Simple search by name or services 
	List<Agencies> findByNameContainingIgnoreCase(String name); 
	
	long countByStatus(String status);
	
	
}
