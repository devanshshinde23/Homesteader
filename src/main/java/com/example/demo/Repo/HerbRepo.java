package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Herb;

public interface HerbRepo extends JpaRepository<Herb , Integer>{

	List<Herb> findByFarmerFid(Long farmerId);
}
