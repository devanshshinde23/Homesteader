package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="fertilizer")
public class Fertilizer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int fertilizerId;
	
	@Column(nullable=false)
	private String fertilizerName ;
	
	@Column(nullable=false )
	private String category ;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable= false)
	private double price ;
	
	@ManyToOne(optional = false)
	@JoinColumn(name ="fid" ,nullable=false)
	@ToString.Exclude
	private Farmer farmer;

	public int getFertilizerId() {
		return fertilizerId;
	}

	public void setFertilizerId(int fertilizerId) {
		this.fertilizerId = fertilizerId;
	}

	public String getFertilizerName() {
		return fertilizerName;
	}

	public void setFertilizerName(String fertilizerName) {
		this.fertilizerName = fertilizerName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	@Override
	public String toString() {
		return "Fertilizer [fertilizerId=" + fertilizerId + ", fertilizerName=" + fertilizerName + ", category="
				+ category + ", quantity=" + quantity + ", price=" + price +  "]";
	}
	
	
	
}
