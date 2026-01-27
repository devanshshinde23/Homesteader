//package com.example.demo.Model;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "service_requests")
//public class ServiceRequest {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    private String type;
//
//    private Integer quantity;  
//    private String unit;
//    
//    private LocalDate preferredDate; 
//    private String deliveryMode;
//	@ManyToOne @JoinColumn(name = "farmer_id")
//    private Farmer farmer;
//
//    @ManyToOne @JoinColumn(name = "agency_id")
//    private Agencies agency;
//
//    @ManyToOne
//    private Crop crop; 
//    @ManyToOne 
//    private Fertilizer fertilizer; 
//    @ManyToOne 
//    private Seed seed; 
//    @ManyToOne 
//    private Herb herb;
//    
//    public Crop getCrop() {
//		return crop;
//	}
//	public void setCrop(Crop crop) {
//		this.crop = crop;
//	}
//	public Fertilizer getFertilizer() {
//		return fertilizer;
//	}
//	public void setFertilizer(Fertilizer fertilizer) {
//		this.fertilizer = fertilizer;
//	}
//	public Seed getSeed() {
//		return seed;
//	}
//	public void setSeed(Seed seed) {
//		this.seed = seed;
//	}
//	public Herb getHerb() {
//		return herb;
//	}
//	public void setHerb(Herb herb) {
//		this.herb = herb;
//	}
//	private String serviceType;
//    private String details;
//    private String status; // PENDING, ACCEPTED, etc.
//    
//    
//    
//    
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	
//	public Integer getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//	public String getUnit() {
//		return unit;
//	}
//	public void setUnit(String unit) {
//		this.unit = unit;
//	}
//	public Farmer getFarmer() {
//		return farmer;
//	}
//	public void setFarmer(Farmer farmer) {
//		this.farmer = farmer;
//	}
//	public Agencies getAgency() {
//		return agency;
//	}
//	public void setAgency(Agencies agency) {
//		this.agency = agency;
//	}
//	public String getServiceType() {
//		return serviceType;
//	}
//	public void setServiceType(String serviceType) {
//		this.serviceType = serviceType;
//	}
//	public String getDetails() {
//		return details;
//	}
//	public void setDetails(String details) {
//		this.details = details;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	
//	
//	
//	public LocalDate getPreferredDate() {
//		return preferredDate;
//	}
//	public void setPreferredDate(LocalDate preferredDate) {
//		this.preferredDate = preferredDate;
//	}
//	public String getDeliveryMode() {
//		return deliveryMode;
//	}
//	public void setDeliveryMode(String deliveryMode) {
//		this.deliveryMode = deliveryMode;
//	}
//	@Override
//	public String toString() {
//		return "ServiceRequest [id=" + id + ", type=" + type + ", farmer=" + farmer + ", agency=" + agency
//				+ ", serviceType=" + serviceType + ", details=" + details + ", status=" + status + ", ]";
//	}
//	public void setRequestDate(LocalDate now) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//    
//    
//}

package com.example.demo.Model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // use int for consistency with your other entities

    private String type;          // general type (optional, can remove if redundant)
    private Integer quantity;
    private String unit;

    private String initiator;
    public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	private LocalDate preferredDate;
    private String deliveryMode;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agencies agency;

    @ManyToOne
    @JoinColumn(name = "crop_id", nullable = true)
    private Crop crop;

    @ManyToOne
    @JoinColumn(name = "fertilizer_id", nullable = true)
    private Fertilizer fertilizer;

    @ManyToOne
    @JoinColumn(name = "seed_id", nullable = true)
    private Seed seed;

    @ManyToOne
    @JoinColumn(name = "herb_id", nullable = true)
    private Herb herb;

    private String serviceType;   // e.g. "Purchase"
    private String details;       // extra notes
    private String status;        // Pending, Approved, Rejected

    private LocalDate requestDate;   // actual request date
    private LocalDate approvedDate;  // when farmer approves

    // ---------------- Getters & Setters ----------------

    

    public String getType() { return type; }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setType(String type) { this.type = type; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public LocalDate getPreferredDate() { return preferredDate; }
    public void setPreferredDate(LocalDate preferredDate) { this.preferredDate = preferredDate; }

    public String getDeliveryMode() { return deliveryMode; }
    public void setDeliveryMode(String deliveryMode) { this.deliveryMode = deliveryMode; }

    public Farmer getFarmer() { return farmer; }
    public void setFarmer(Farmer farmer) { this.farmer = farmer; }

    public Agencies getAgency() { return agency; }
    public void setAgency(Agencies agency) { this.agency = agency; }

    public Crop getCrop() { return crop; }
    public void setCrop(Crop crop) { this.crop = crop; }

    public Fertilizer getFertilizer() { return fertilizer; }
    public void setFertilizer(Fertilizer fertilizer) { this.fertilizer = fertilizer; }

    public Seed getSeed() { return seed; }
    public void setSeed(Seed seed) { this.seed = seed; }

    public Herb getHerb() { return herb; }
    public void setHerb(Herb herb) { this.herb = herb; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }

    public LocalDate getApprovedDate() { return approvedDate; }
    public void setApprovedDate(LocalDate approvedDate) { this.approvedDate = approvedDate; }

    @Override
    public String toString() {
        return "ServiceRequest [id=" + id + ", type=" + type + ", farmer=" + farmer +
               ", agency=" + agency + ", serviceType=" + serviceType +
               ", details=" + details + ", status=" + status + "]";
    }
}
