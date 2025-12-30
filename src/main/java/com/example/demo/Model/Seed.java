package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="seed")
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seedid;
	
	@Column(nullable = false)
	private String seedName;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private String category;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "fid", nullable = false)
    private Farmer farmer;
	
	
	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public int getSeedid() {
		return seedid;
	}

	public void setSeedid(int seedid) {
		this.seedid = seedid;
	}

	public String getSeedName() {
		return seedName;
	}

	public void setSeedName(String seedName) {
		this.seedName = seedName;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Seed [seedid=" + seedid + ", seedName=" + seedName + ", quantity=" + quantity + ", price=" + price
				+ ", category=" + category + ", farmer=" + farmer + "]";
	}

	
	
	
}
