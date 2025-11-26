package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agencies {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int aid;
	private String aname;
	private String aownerName;
	private int aregisterNo;
	private String atype;
	private String amobno;
	private String aaddress;
	private String ausername;
	private String apassword;
	@Override
	public String toString() {
		return "Agencies [aid=" + aid + ", aname=" + aname + ", aownerName=" + aownerName + ", aregisterNo="
				+ aregisterNo + ", atype=" + atype + ", amobno=" + amobno + ", aaddress=" + aaddress + ", ausername="
				+ ausername + ", apassword=" + apassword + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAownerName() {
		return aownerName;
	}
	public void setAownerName(String aownerName) {
		this.aownerName = aownerName;
	}
	public int getAregisterNo() {
		return aregisterNo;
	}
	public void setAregisterNo(int aregisterNo) {
		this.aregisterNo = aregisterNo;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getAmobno() {
		return amobno;
	}
	public void setAmobno(String amobno) {
		this.amobno = amobno;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public String getAusername() {
		return ausername;
	}
	public void setAusername(String ausername) {
		this.ausername = ausername;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	
	
	
	
}
