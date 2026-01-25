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
	
//	public void buyCrop(Long agencyId, int cropId, int quantity, Agencies agency, Farmer farmer)
//	 { 
//		Crop crop = cropRepo.findById(cropId).orElseThrow(); 
//	ServiceRequest req = new ServiceRequest(); 
//	req.setAgency(agency);
//	 req.setFarmer(farmer); 
//	req.setCrop(crop);
//	 req.setQuantity(quantity);
//	 req.setStatus("Pending");
//	 req.setRequestDate(java.time.LocalDate.now()); 
//	 dao.save(req);
//	 }
//	
//	public void buyFertilizer(Long agencyId, int fertId, int quantity, Agencies agency, Farmer farmer) 
//	{ 
//		Fertilizer fert = fertilizerRepo.findById(fertId).orElseThrow();
//		ServiceRequest req = new ServiceRequest();
//		req.setAgency(agency);
//		req.setFarmer(farmer);
//		req.setFertilizer(fert);
//		req.setQuantity(quantity);
//		req.setStatus("Pending");
//		req.setRequestDate(java.time.LocalDate.now()); 
//		dao.save(req); 
//		
//	}
//	
//	public void buySeed(Long agencyId, int seedId, int quantity, Agencies agency, Farmer farmer) 
//	{ 
//		Seed seed = seedRepo.findById(seedId).orElseThrow();
//		ServiceRequest req = new ServiceRequest();
//		req.setAgency(agency); 
//		req.setFarmer(farmer); 
//		req.setSeed(seed); 
//		req.setQuantity(quantity);
//		
//		req.setStatus("Pending"); 
//		req.setRequestDate(java.time.LocalDate.now());
//		dao.save(req); 
//		
//	}
//	
//	public void buyHerb(Long agencyId, int herbId, int quantity, Agencies agency, Farmer farmer) 
//	{
//		Herb herb = herbRepo.findById(herbId).orElseThrow(); 
//		ServiceRequest req = new ServiceRequest();
//		req.setAgency(agency);
//		req.setFarmer(farmer); 
//		req.setHerb(herb);
//		req.setQuantity(quantity);
//		req.setStatus("Pending"); 
//		req.setRequestDate(java.time.LocalDate.now());
//		dao.save(req); 
//		
//	}
//	
	
	public void buyCrop(int cropId, int quantity, Agencies agency) {
	    Crop crop = cropRepo.findById(cropId).orElseThrow();
	    ServiceRequest req = buildRequest(agency, crop.getFarmer(), quantity);
	    req.setCrop(crop);
	    dao.save(req);
	}

	public void buyFertilizer(int fertId, int quantity, Agencies agency) {
	    Fertilizer fert = fertilizerRepo.findById(fertId).orElseThrow();
	    ServiceRequest req = buildRequest(agency, fert.getFarmer(), quantity);
	    req.setFertilizer(fert);
	    dao.save(req);
	}

	public void buySeed(int seedId, int quantity, Agencies agency) {
	    Seed seed = seedRepo.findById(seedId).orElseThrow();
	    ServiceRequest req = buildRequest(agency, seed.getFarmer(), quantity);
	    req.setSeed(seed);
	    dao.save(req);
	}

	public void buyHerb(int herbId, int quantity, Agencies agency) {
	    Herb herb = herbRepo.findById(herbId).orElseThrow();
	    ServiceRequest req = buildRequest(agency, herb.getFarmer(), quantity);
	    req.setHerb(herb);
	    dao.save(req);
	}

	// Helper method to reduce duplication
	private ServiceRequest buildRequest(Agencies agency, Farmer farmer, int quantity) {
	    ServiceRequest req = new ServiceRequest();
	    req.setAgency(agency);
	    req.setFarmer(farmer);
	    req.setQuantity(quantity);
	    req.setStatus("Pending");
	    req.setRequestDate(java.time.LocalDate.now());
	    return req;
	}

	public void updateStatus1(Long requestId, String status) {
		ServiceRequest req = dao.findById(requestId).orElseThrow();
		req.setStatus(status);
		dao.save(req); 
		
	}

	@Override
	public void save(ServiceRequest req) {
		// TODO Auto-generated method stub
		
	}
}
