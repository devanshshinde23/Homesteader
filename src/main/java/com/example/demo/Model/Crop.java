package com.example.demo.Model;

import javax.persistence.*;

import lombok.ToString;

@Entity
@Table(name = "crop")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cropId;

    @Column(nullable = false)
    private String cropName;

    @Column(nullable = false)
    private String cropType;

    private int quantity;

    private double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fid", nullable = false)
    @ToString.Exclude
    private Farmer farmer;

    // Getters & Setters

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
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
        return "Crop [cropId=" + cropId +
               ", cropName=" + cropName +
               ", cropType=" + cropType +
               ", quantity=" + quantity +
               ", price=" + price + "]";
    }
}
