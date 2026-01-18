package com.example.demo.Dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Agencies;
import com.example.demo.Model.Farmer;
import com.example.demo.Model.ServiceRequest;
import com.example.demo.Repo.AgenciesRepo;
import com.example.demo.Repo.FarmerRepo;
import com.example.demo.Repo.ServiceRequestRepository;
import com.example.demo.Service.ServiceRequestService;

@Service
public class ServiceRequestDao implements ServiceRequestService{

	@Autowired private FarmerRepo farmerRepo; 
	@Autowired private AgenciesRepo agencyRepo;
	@Autowired private ServiceRequestRepository dao;
	
	
//	@Override
//	public ServiceRequest createRequest(Long farmerId, Long agencyId, String type, String details) {
//		 
//		 
//			Farmer farmer = farmerRepo.findByFid(farmerId).orElseThrow(); 
//			Agencies agency = agencyRepo.findByAid(agencyId).orElseThrow(); 
//			ServiceRequest req = new ServiceRequest(); 
//			req.setFarmer(farmer); 
//			req.setAgency(agency);
//			req.setServiceType(type);
//			req.setDetails(details);
//			req.setStatus("PENDING"); req.setCreatedAt(LocalDateTime.now()); 
//			
//			return dao.save(req);
//		
//	}

	@Override
	public List<ServiceRequest> getFarmerRequests(Long farmerId) {
		return dao.findByFarmerFid(farmerId);
	}

	@Override
	public List<ServiceRequest> getAgencyRequests(Long agencyId) {
		
		return dao.findByAgencyAid(agencyId);
	}

	@Override
	public ServiceRequest updateStatus(Long requestId, String status) {
		ServiceRequest req = dao.findById(requestId).orElseThrow();
		req.setStatus(status); 
		 
		return dao.save(req);
	}
	
	public void createRequest(Long farmerId, Long agencyId, String type, String details,
            Integer quantity, String unit, LocalDate preferredDate, String deliveryMode) {
ServiceRequest req = new ServiceRequest();
req.setFarmer(farmerRepo.findByFid(farmerId).orElse(null));
req.setAgency(agencyRepo.findByAid(agencyId).orElse(null));
req.setType(type);
req.setDetails(details);
req.setQuantity(quantity);
req.setUnit(unit);
req.setPreferredDate(preferredDate);
req.setDeliveryMode(deliveryMode);
req.setStatus("Pending");
dao.save(req);
}


}
