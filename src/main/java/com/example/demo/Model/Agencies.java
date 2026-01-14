//package com.example.demo.Model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Agencies {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	
//	private int aid;
//	private String aname;
//	private String aownerName;
//	private int aregisterNo;
//	private String atype;
//	private String amobno;
//	private String aaddress;
//	private String ausername;
//	private String apassword;
//	@Override
//	public String toString() {
//		return "Agencies [aid=" + aid + ", aname=" + aname + ", aownerName=" + aownerName + ", aregisterNo="
//				+ aregisterNo + ", atype=" + atype + ", amobno=" + amobno + ", aaddress=" + aaddress + ", ausername="
//				+ ausername + ", apassword=" + apassword + "]";
//	}
//	public int getAid() {
//		return aid;
//	}
//	public void setAid(int aid) {
//		this.aid = aid;
//	}
//	public String getAname() {
//		return aname;
//	}
//	public void setAname(String aname) {
//		this.aname = aname;
//	}
//	public String getAownerName() {
//		return aownerName;
//	}
//	public void setAownerName(String aownerName) {
//		this.aownerName = aownerName;
//	}
//	public int getAregisterNo() {
//		return aregisterNo;
//	}
//	public void setAregisterNo(int aregisterNo) {
//		this.aregisterNo = aregisterNo;
//	}
//	public String getAtype() {
//		return atype;
//	}
//	public void setAtype(String atype) {
//		this.atype = atype;
//	}
//	public String getAmobno() {
//		return amobno;
//	}
//	public void setAmobno(String amobno) {
//		this.amobno = amobno;
//	}
//	public String getAaddress() {
//		return aaddress;
//	}
//	public void setAaddress(String aaddress) {
//		this.aaddress = aaddress;
//	}
//	public String getAusername() {
//		return ausername;
//	}
//	public void setAusername(String ausername) {
//		this.ausername = ausername;
//	}
//	public String getApassword() {
//		return apassword;
//	}
//	public void setApassword(String apassword) {
//		this.apassword = apassword;
//	}
//	
//	
//	
//	
//}

package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "agencies")
public class Agencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @NotBlank(message = "Agency name is required")
    private String name;

    @NotBlank(message = "Owner name is required")
    private String ownerName;

    @NotBlank(message = "Registration number is required")
    private String registerNo;

    @NotBlank(message = "Agency type is required")
    private String type; // Fertilizer, Seeds, Buyer, etc.

    @NotBlank(message = "Mobile number is required")
    @Size(min = 10, max = 15)
    private String mobileNo;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password; // store hashed, not plain text

    private String status = "ACTIVE"; // default

    private String village;

    public String getVillage() { return village; }
    public void setVillage(String village) { this.village = village; }

    
	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Agencies [aid=" + aid + ", name=" + name + ", ownerName=" + ownerName + ", registerNo=" + registerNo
				+ ", type=" + type + ", mobileNo=" + mobileNo + ", address=" + address + ", username=" + username
				+ ", password=" + password + ", status=" + status + "]";
	}

    
}

