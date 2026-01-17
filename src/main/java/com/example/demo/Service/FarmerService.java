package com.example.demo.Service;

import com.example.demo.Model.Farmer;
import com.example.demo.Model.ServiceRequest;

import java.util.List;



public interface FarmerService {

	public void register(Farmer f1);

	public Farmer CheckFarmerData(String u, String p);

	public List<Farmer> Display();
	
	public Farmer getFarmerId(int fid);
	
	
	public Farmer saveFarmer(Farmer farmer);

	public Farmer login(String username, String password);
	
	public Farmer getFarmerDetails(int fid );

	
	public List<Farmer> findByname(String fname);

	public List<Farmer> fetchData(String name);

	List<ServiceRequest> getFarmerRequests(Long farmerId);
	
	

}
