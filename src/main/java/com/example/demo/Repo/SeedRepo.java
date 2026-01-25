package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Seed;

public interface SeedRepo extends JpaRepository<Seed, Integer>{

	List<Seed> findByFarmerFid(Long farmerId);
}
