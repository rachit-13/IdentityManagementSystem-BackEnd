package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Aadhar;
import com.example.demo.entity.Pan;
import com.example.demo.entity.User;
import com.example.demo.persistance.AadharRepository;
import com.example.demo.persistance.PanRepository;
import com.example.demo.persistance.RegistrationRepository;

@Service
public class Service_Implementations implements Service_declarations {
	
	private AadharRepository ajpa;
	private PanRepository pjpa;
	
	
	
	@Autowired
	public Service_Implementations(AadharRepository ajpa,PanRepository pjpa) {
		
		this.ajpa = ajpa;
		this.pjpa = pjpa;
	}
	
	@Autowired
	private RegistrationRepository rr;
	
	public User saveUser(User user)
	{
		return rr.save(user);
	}
	
	public User fetchUserByEmailId(String email)
	{
		return rr.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPasswordAndRole(String email, String password, String role)
	{
		return rr.findByEmailIdAndPasswordAndRole(email, password, role);
	}

	@Override
	@Transactional
	public void insertCitizen(Aadhar a) {
//		a.setAadharNum(null);
		ajpa.save(a);
		
	}

	@Override
	@Transactional
	public List<Aadhar> getAllCitizens() {
		List<Aadhar> list = ajpa.findAll();
		return list;
	}

	@Override
	@Transactional
	public Aadhar getAllCitizensByAadharNum(String aadharNum) {
		Aadhar allCitizens = ajpa.findCitizenByaadharNum(aadharNum);
		return allCitizens;
	}

	@Override
	@Transactional
	public List<Aadhar> getRecordByCitizenName(String name) {
		List<Aadhar> list = ajpa.searchCitizenByName(name);
		return list;
	}

	@Override
	@Transactional
	public void DeleteCitizenByAadharNum(String aadharNum) {
		ajpa.deleteByAadharNum(aadharNum);
		
	}

	@Override
	@Transactional
	public void UpdateCitizen(Aadhar a) {
		ajpa.save(a);		
	}

	@Override
	@Transactional
	public void insertCitizenP(Pan p) {
		pjpa.save(p);
		
	}

	@Override
	@Transactional
	public List<Pan> getAllCitizensP() {
		List<Pan> list = pjpa.findAll();
		return list;
	}

	@Override
	@Transactional
	public Pan getAllCitizensByPanNum(String panNum) {
		Pan allCitizens = pjpa.findCitizenByPanNum(panNum);
		return allCitizens;
	}

//	@Override
//	@Transactional
//	public List<Pan> getRecordByCitizenNameP(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	@Transactional
	public void DeleteCitizenByPanNum(String panNum) {
		pjpa.deleteById(panNum);
		
	}

	@Override
	@Transactional
	public void UpdateCitizenP(Pan p) {
		pjpa.save(p);
		
	}

	public Pan fetchUserByNameAndMobileNum(String name, String mobileNum) {
		return pjpa.findByNameAndMobileNum(name, mobileNum);
	}
	
	public Aadhar fetchUserByNameAndMobileNumA(String name, String mobileNum) {
		return ajpa.findByNameAndMobileNum(name, mobileNum);
	}
	
	public Pan fetchUserByNameAndMobileNumAndPanNum(String name, String mobileNum,String panNum) {
		return pjpa.findByNameAndMobileNumAndPanNum(name,mobileNum,panNum);
	}
	
	public Aadhar fetchUserByNameAndMobileNumAndAadharNum(String name, String mobileNum,String aadharNum) {
		return ajpa.findByNameAndMobileNumAndAadharNum(name,mobileNum,aadharNum);
	}

}
	
	