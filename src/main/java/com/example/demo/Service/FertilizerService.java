package com.example.demo.Service;

import com.example.demo.Model.Fertilizer;

public interface FertilizerService {

	public void AddFertilizer(Fertilizer f1, Integer farmerId);

	public  Fertilizer findById(Long fertilizerId);

	public Object getAllFertilizers();

}
