package com.example.demo.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String type;

    private Integer quantity;  
    private String unit;
    
    private LocalDate preferredDate; 
    private String deliveryMode;
	@ManyToOne @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @ManyToOne @JoinColumn(name = "agency_id")
    private Agencies agency;

    private String serviceType;
    private String details;
    private String status; // PENDING, ACCEPTED, etc.
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public Agencies getAgency() {
		return agency;
	}
	public void setAgency(Agencies agency) {
		this.agency = agency;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public LocalDate getPreferredDate() {
		return preferredDate;
	}
	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", type=" + type + ", farmer=" + farmer + ", agency=" + agency
				+ ", serviceType=" + serviceType + ", details=" + details + ", status=" + status + "]";
	}
	
    
    
}
