package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{

	Admin findByAusernameAndApassword(String u, String p);

	
}
