package com.example.demo.Dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Agencies;
import com.example.demo.Model.Crop;
import com.example.demo.Model.Farmer;
import com.example.demo.Model.Fertilizer;
import com.example.demo.Model.Herb;
import com.example.demo.Model.Seed;
import com.example.demo.Model.ServiceRequest;
import com.example.demo.Repo.AgenciesRepo;
import com.example.demo.Repo.CropRepo;
import com.example.demo.Repo.FarmerRepo;
import com.example.demo.Repo.FertilizerRepo;
import com.example.demo.Repo.HerbRepo;
import com.example.demo.Repo.SeedRepo;
import com.example.demo.Repo.ServiceRequestRepository;
import com.example.demo.Service.ServiceRequestService;

@Service
public class ServiceRequestDao implements ServiceRequestService{

	@Autowired private FarmerRepo farmerRepo; 
	@Autowired private AgenciesRepo agencyRepo;
	@Autowired private ServiceRequestRepository dao;
	
	@Autowired private CropRepo cropRepo; 
	@Autowired private FertilizerRepo fertilizerRepo; 
	@Autowired private SeedRepo seedRepo;
	@Autowired private HerbRepo herbRepo;
	


	@Override
	public List<ServiceRequest> getFarmerRequests(Long farmerId) {
		return dao.findByFarmerFidAndInitiator(farmerId, "AGENCY");
	}

	@Override
	public List<ServiceRequest> getAgencyRequests(Long agencyId) {
		
		return dao.findByFarmerFidAndInitiator(agencyId, "FARMER");
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

	

	
	
	public long countAllByAgency(Long agencyId) 
	{ 
		return dao.countByAgency_Aid(agencyId); 
	} 
	
	public long countByStatus(Long agencyId, String status) 
	{
		return dao.countByAgency_AidAndStatus(agencyId, status); 
	}
	
	 
	
	public long countAllByFarmer(Long farmerId) 
	{ 
		return dao.countByFarmerFid(farmerId); 
		
	}
	public long countByFarmerStatus(Long farmerId, String status) 
	{ 
		return dao.countByFarmerFidAndStatus(farmerId, status); 
		
	}
	

	
//	public void buyCrop(int cropId, int quantity, Agencies agency) {
//	    Crop crop = cropRepo.findById(cropId).orElseThrow();
//	    ServiceRequest req = buildRequest(agency, crop.getFarmer(), quantity);
//	    req.setCrop(crop);
//	    dao.save(req);
//	}
//
//	public void buyFertilizer(int fertId, int quantity, Agencies agency) {
//	    Fertilizer fert = fertilizerRepo.findById(fertId).orElseThrow();
//	    ServiceRequest req = buildRequest(agency, fert.getFarmer(), quantity);
//	    req.setFertilizer(fert);
//	    dao.save(req);
//	}
//
//	public void buySeed(int seedId, int quantity, Agencies agency) {
//	    Seed seed = seedRepo.findById(seedId).orElseThrow();
//	    ServiceRequest req = buildRequest(agency, seed.getFarmer(), quantity);
//	    req.setSeed(seed);
//	    dao.save(req);
//	}
//
//	public void buyHerb(int herbId, int quantity, Agencies agency) {
//	    Herb herb = herbRepo.findById(herbId).orElseThrow();
//	    ServiceRequest req = buildRequest(agency, herb.getFarmer(), quantity);
//	    req.setHerb(herb);
//	    dao.save(req);
//	}
	
	public void buyCrop(int cropId, int quantity, Agencies agency) {
	    Crop crop = cropRepo.findById(cropId).orElseThrow();
	    ServiceRequest req = buildRequest(agency, crop.getFarmer(), quantity, "AGENCY", "Crop");
	    req.setCrop(crop);
	    dao.save(req);
	}

	public void buyFertilizer(int fertId, int quantity, Agencies agency) {
	    Fertilizer fert = fertilizerRepo.findById(fertId).orElseThrow();
	    ServiceRequest req = buildRequest(agency, fert.getFarmer(), quantity, "AGENCY", "Fertilizer");
	    req.setFertilizer(fert);
	    dao.save(req);
	}

	public void buySeed(int seedId, int quantity, Agencies agency) {
	    Seed seed = seedRepo.findById(seedId).orElseThrow();
	    ServiceRequest req = buildRequest(agency, seed.getFarmer(), quantity, "AGENCY", "Seed");
	    req.setSeed(seed);
	    dao.save(req);
	}

	public void buyHerb(int herbId, int quantity, Agencies agency) {
	    Herb herb = herbRepo.findById(herbId).orElseThrow();
	    ServiceRequest req = buildRequest(agency, herb.getFarmer(), quantity, "AGENCY", "Herb");
	    req.setHerb(herb);
	    dao.save(req);
	}


	// Helper method to reduce duplication
//	private ServiceRequest buildRequest(Agencies agency, Farmer farmer, int quantity) {
//	    ServiceRequest req = new ServiceRequest();
//	    req.setAgency(agency);
//	    req.setFarmer(farmer);
//	    req.setQuantity(quantity);
//	    req.setStatus("Pending");
//	    req.setRequestDate(java.time.LocalDate.now());
//	    return req;
//	}

	private ServiceRequest buildRequest(Agencies agency,
		            Farmer farmer,
		            int quantity,
		            String initiator,
		            String productType) {
			ServiceRequest req = new ServiceRequest();
			
			// common fields
			req.setAgency(agency);
			req.setFarmer(farmer);
			req.setQuantity(quantity);
			req.setStatus("Pending");
			req.setRequestDate(java.time.LocalDate.now());
			
			// who initiated the request
			req.setInitiator(initiator); // "FARMER" or "AGENCY"
			
			// optional: tag the type of product/service
			req.setServiceType(productType); // e.g. "Crop", "Seed", "Fertilizer", "Herb", "Service"
			
			return req;
}

	public void updateStatus1(Long requestId, String status) {
//		ServiceRequest req = dao.findById(requestId).orElseThrow();
//		req.setStatus(status);
//		dao.save(req); 
		
		ServiceRequest req = dao.findById(requestId).orElseThrow();
		req.setStatus(status); 
			if ("Approved".equalsIgnoreCase(status)) 
			{
				req.setApprovedDate(LocalDate.now()); 
				
			}
			dao.save(req); 
		
	}
	
	

	@Override
	public void save(ServiceRequest req) {
		dao.save(req);
		
	}

	@Override
	public ServiceRequest updateStatus(int id, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
