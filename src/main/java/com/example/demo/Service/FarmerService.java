package com.example.demo.Service;

import com.example.demo.Model.Farmer;
import java.util.List;



public interface FarmerService {

	public void register(Farmer f1);

	public Farmer CheckFarmerData(String u, String p);

	public List<Farmer> Display();

}
