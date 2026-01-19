package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;



import com.example.demo.Model.ServiceRequest;


public interface ServiceRequestService {

//	ServiceRequest createRequest(Long farmerId, Long agencyId, String type, String details); 
	List<ServiceRequest> getFarmerRequests(Long farmerId);
	List<ServiceRequest> getAgencyRequests(Long agencyId); 
	ServiceRequest updateStatus(Long requestId, String status);
	public void createRequest(Long farmerFid, Long agencyAid, String type, String details,
            Integer quantity, String unit, LocalDate preferredDate, String deliveryMode);
	
	
	public long countAllByAgency(Long agencyId); 
	public long countByStatus(Long agencyId, String status); 
}
