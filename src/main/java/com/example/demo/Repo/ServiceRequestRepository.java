package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> 
{
	List<ServiceRequest> findByFarmer_Fid(Long farmerId);
	List<ServiceRequest> findByAgency_Aid(Long agencyId);
//	List<ServiceRequest> findByFarmerFid(Long farmerId);
//	List<ServiceRequest> findByAgencyAid(Long agencyId);
	
	// Farmer dashboard: show only agency-initiated buying requests
	List<ServiceRequest> findByFarmerFidAndInitiator(Long farmerId, String initiator);

	// Agency dashboard: show only farmer-initiated service requests
	List<ServiceRequest> findByAgencyAidAndInitiator(Long agencyId, String initiator);

	long countByAgency_Aid(Long agencyId);
	long countByAgency_AidAndStatus(Long agencyId, String status);
	long countByFarmerFid(Long farmerId);
	long countByFarmerFidAndStatus(Long farmerId, String status);
	long countByFarmerFid(int farmerId);
	long countByFarmerFidAndStatus(int farmerId, String status); 
}
