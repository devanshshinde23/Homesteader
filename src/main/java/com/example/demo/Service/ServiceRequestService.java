package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.Model.Agencies;
import com.example.demo.Model.Farmer;
import com.example.demo.Model.ServiceRequest;


public interface ServiceRequestService {

//	ServiceRequest createRequest(Long farmerId, Long agencyId, String type, String details); 
	List<ServiceRequest> getFarmerRequests(Long farmerId);
	List<ServiceRequest> getAgencyRequests(Long agencyId); 
	ServiceRequest updateStatus(int id, String status);
	public void createRequest(Long farmerFid, Long agencyAid, String type, String details,
            Integer quantity, String unit, LocalDate preferredDate, String deliveryMode);
	
	
	public long countAllByAgency(Long agencyId); 
	public long countByStatus(Long agencyId, String status); 
	
	public void buyCrop(int cropId, int quantity, Agencies agency);
	
	public void buyFertilizer(int fertId, int quantity, Agencies agency);
	
	public void buySeed(int seedId, int quantity, Agencies agency);
	
	public void buyHerb(int herbId, int quantity, Agencies agency);
	
//	public void buyCrop(Long agencyId, int cropId, int quantity, Agencies agency, Farmer farmer);
//	
//	public void buyFertilizer(Long agencyId, int fertId, int quantity, Agencies agency, Farmer farmer) ;
//	
//	public void buySeed(Long agencyId, int seedId, int quantity, Agencies agency, Farmer farmer) ;
//	
//	public void buyHerb(Long agencyId, int herbId, int quantity, Agencies agency, Farmer farmer) ;
	
	void save(ServiceRequest req);
	
	public long countAllByFarmer(Long farmerId); 
	
	public long countByFarmerStatus(Long farmerId, String status);
	ServiceRequest updateStatus(Long requestId, String status);
	
	
	
	
	 
}
