package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Fertilizer;

public interface FertilizerRepo extends JpaRepository <Fertilizer , Integer>{

	List<Fertilizer> findByFarmerFid(Long farmerId);
}
