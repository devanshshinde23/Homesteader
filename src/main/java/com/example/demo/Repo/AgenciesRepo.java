package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Agencies;

public interface AgenciesRepo extends JpaRepository<Agencies,Integer>{

	Agencies findByAusernameAndApassword(String u, String p);
	
	Agencies findByAname(String u);
	
	
}
