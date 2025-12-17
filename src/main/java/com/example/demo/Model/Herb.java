package com.example.demo.Model;

import javax.persistence.*; 

@Entity
@Table(name="herb")
public class Herb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int herbid;
	
	@Column(nullable = false)
	private String herbName;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private String category;
	
	
	 @Override
	public String toString() {
		return "Herb [herbid=" + herbid + ", herbName=" + herbName + ", quantity=" + quantity + ", price=" + price
				+ ", category=" + category + ", farmer=" + farmer + "]";
	}


	 public int getHerbid() {
		return herbid;
	}


	public void setHerbid(int herbid) {
		this.herbid = herbid;
	}


	public String getHerbName() {
		return herbName;
	}


	public void setHerbName(String herbName) {
		this.herbName = herbName;
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


	public Farmer getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}


	 @ManyToOne(optional = false)
	    @JoinColumn(name = "fid", nullable = false)
	    private Farmer farmer;
	
	
	

}
