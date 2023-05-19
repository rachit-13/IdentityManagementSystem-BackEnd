package com.example.demo.entity;

import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity   //regarding entity details
@Table(name="Pan") //table name
public class Pan {
	
	@Id                 //tells regarding pk
	@Column(name="PanNumber")   //tells regarding column name
	private String panNum;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobileNum")
	private String mobileNum;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="fatherName")
	private String fatherName;
	private static String generatePanNum = "GDFGT1476J";
	
   
    
	public Pan() {		
		
	}

	public Pan(String panNum, String name, String mobileNum, String dob, String gender, String fatherName,
			Aadhar aadhar) {
		this.panNum = panNum;
		this.name = name;
		this.mobileNum = mobileNum;
		this.dob = dob;
		this.gender = gender;
		this.fatherName = fatherName;
//		this.aadhar = aadhar;
	}

	public String getPanNum() {
		return panNum;
	}

	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
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

	public static String getGeneratePanNum() {
		return generatePanNum;
	}

	public static void setGeneratePanNum(String generatePanNum) {
		Pan.generatePanNum = generatePanNum;
	}

	@Override
	public String toString() {
		return "Pan [panNum=" + panNum + ", name=" + name + ", mobileNum=" + mobileNum + ", dob=" + dob + ", gender="
				+ gender + ", fatherName=" + fatherName + "]";
	}

//	public Aadhar getAadhar() {
//		return aadhar;
//	}
//
//	public void setAadhar(Aadhar aadhar) {
//		this.aadhar = aadhar;
//	}

	
}
