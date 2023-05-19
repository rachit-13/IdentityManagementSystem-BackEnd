package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity   //regarding entity details
@Table(name="Aadhar") //table name
public class Aadhar {
	@Id                 //tells regarding pk	
	@Column(name="AadharNumber")   //tells regarding column name
	private String aadharNum;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="fatherName")
	private String fatherName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="MobileNumber")   
	private String mobileNum;
	
	@Column(name="PanNum")
	private String panNum;
	
	
   
	
	public Aadhar() {

	}

	public Aadhar(String aadharNum, String name, String dob, String gender, String fatherName, String address,
			String mobileNum, String panNum) {
		this.aadharNum = aadharNum;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.fatherName = fatherName;
		this.address = address;
		this.mobileNum = mobileNum;
		this.panNum = panNum;
	}

	public String getAadharNum() {
		return aadharNum;
	}

	public void setAadharNum(String aadharNum) {
		this.aadharNum = aadharNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public String getPanNum() {
		return panNum;
	}

	public void setPan(String panNum) {
		this.panNum = panNum;
	}

	@Override
	public String toString() {
		return "Aadhar [aadharNum=" + aadharNum + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", fatherName=" + fatherName + ", address=" + address + ", mobileNum=" + mobileNum + "]";
	}	
}
