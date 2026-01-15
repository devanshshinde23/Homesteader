package com.example.demo.Service;

import java.util.List;



import com.example.demo.Model.ServiceRequest;


public interface ServiceRequestService {

	ServiceRequest createRequest(Long farmerId, Long agencyId, String type, String details); 
	List<ServiceRequest> getFarmerRequests(Long farmerId);
	List<ServiceRequest> getAgencyRequests(Long agencyId); 
	ServiceRequest updateStatus(Long requestId, String status);
}
