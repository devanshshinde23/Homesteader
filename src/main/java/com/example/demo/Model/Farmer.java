package com.example.demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="farmer")
public class Farmer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fid ;
	private String fname;
	private String fMobileNo;
	private String femail;
	private String fregion;
	private String fusername;
	
	private String fpassword;
	@Transient  // Not store in database 
	private String fcpassword;
	
	public List<Crop> getCrops() {
		return crops;
	}
	public void setCrops(List<Crop> crops) {
		this.crops = crops;
	}

	@OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
	private List<Crop> crops;
	
	public String getFcpassword() {
		return fcpassword;
	}
	public void setFcpassword(String fcpassword) {
		this.fcpassword = fcpassword;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getfMobileNo() {
		return fMobileNo;
	}
	public void setfMobileNo(String fMobileNo) {
		this.fMobileNo = fMobileNo;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFregion() {
		return fregion;
	}
	public void setFregion(String fregion) {
		this.fregion = fregion;
	}
	public String getFusername() {
		return fusername;
	}
	public void setFusername(String fusername) {
		this.fusername = fusername;
	}
	public String getFpassword() {
		return fpassword;
	}
	public void setFpassword(String fpassword) {
		this.fpassword = fpassword;
	}
	
	@Override
	public String toString() {
		return "Farmer [fid=" + fid + ", fname=" + fname + ", fMobileNo=" + fMobileNo + ", femail=" + femail
				+ ", fregion=" + fregion + ", fusername=" + fusername + ", fpassword=" + fpassword + ", fcpassword="
				+ fcpassword + "]";
	}
	
	
	
	
}
