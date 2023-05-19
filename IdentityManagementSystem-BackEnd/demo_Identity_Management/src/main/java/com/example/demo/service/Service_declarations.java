package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Aadhar;
import com.example.demo.entity.Pan;

public interface Service_declarations {
	
///// Aadhar entity
	public void insertCitizen(Aadhar a);
	public List<Aadhar> getAllCitizens();
	public Aadhar getAllCitizensByAadharNum(String aadharNum);
	public List<Aadhar> getRecordByCitizenName(String name);
	public void DeleteCitizenByAadharNum(String aadharNum);
	public void UpdateCitizen(Aadhar a);
	
///// Pan entity
	public void insertCitizenP(Pan p);
	public List<Pan> getAllCitizensP();
	public Pan getAllCitizensByPanNum(String panNum);
//	public List<Pan> getRecordByCitizenNameP(String name);
	public void DeleteCitizenByPanNum(String panNum);
	public void UpdateCitizenP(Pan p);
}
