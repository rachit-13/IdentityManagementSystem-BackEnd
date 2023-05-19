package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Aadhar;
import com.example.demo.entity.Pan;
import com.example.demo.entity.User;
import com.example.demo.service.Service_Implementations;

@RestController
@RequestMapping("/aadhar")
public class Aadhar_Controller {
	
	private Service_Implementations simp;
	
	@Autowired
	public Aadhar_Controller(Service_Implementations simp) {
		this.simp = simp;
	}

	
	@GetMapping("list")            //http://localhost:8080/aadhar/list
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Aadhar> getAllCitizens(){
		return simp.getAllCitizens();
	}
	
	
	@GetMapping("list2/{aadharNum}")     //http://localhost:8080/aadhar/list2/100110011002
//	@CrossOrigin(origins = "http://localhost:4200")
	public Aadhar getCitizensByAadharNum(@PathVariable("aadharNum") String aadharNum) throws Exception{
		Aadhar aadhar = null;
		aadhar =  simp.getAllCitizensByAadharNum(aadharNum);
		if(aadhar !=null) {
			return aadhar;
		}else {
			throw new Exception("User with aadhar number not found");
		}
	}
	
//	@GetMapping("list3/{name}")          //http://localhost:8080/aadhar/list3/Sumit Kumar
//	public List<Aadhar> getCitizenByName(@PathVariable("name") String name){
//		return simp.getRecordByCitizenName(name);
//	}
	
	@PostMapping("addCitizen")             //http://localhost:8080/aadhar/addCitizen
	@CrossOrigin(origins = "http://localhost:4200")
	public void addCitizen(@RequestBody Aadhar a) throws Exception {
		Aadhar adh =simp.fetchUserByNameAndMobileNumA(a.getName(), a.getMobileNum());
		if(adh==null) {
			a.setAadharNum(generateAadharNumber());
			simp.insertCitizen(a);
		}else {
			throw new Exception("User already exist");
		}
		
	}
	
	@DeleteMapping("list/{aadharNum}")           //http://localhost:8080/aadhar/list/100110011004
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteCitizen(@PathVariable("aadharNum") String aadharNum)  {
			simp.DeleteCitizenByAadharNum(aadharNum);
		}
	
	
	@PutMapping("list1")             //http://localhost:8080/aadhar/list1(pass aadharNum in body)
	@CrossOrigin(origins = "http://localhost:4200")
	public void updateCitizenDetails(@RequestBody Aadhar a) {
		simp.UpdateCitizen(a);
	}
	
	public static String generateAadharNumber() {
		
        String characters = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            char c = characters.charAt(random.nextInt(characters.length()));
            sb.append(c);
        }
        sb.append(characters.charAt(random.nextInt(characters.length())));
        return sb.toString();
    }
	
		@PutMapping("link")             //http://localhost:8080/aadhar/link
		@CrossOrigin(origins = "http://localhost:4200")
		public void link(@RequestBody Aadhar ad) throws Exception {
		Aadhar a = simp.getAllCitizensByAadharNum(ad.getAadharNum());
		Pan pn = simp.getAllCitizensByPanNum(ad.getPanNum());
		Aadhar adh = simp.fetchUserByNameAndMobileNumAndAadharNum(a.getName(), a.getMobileNum(), a.getAadharNum());
		Pan p = simp.fetchUserByNameAndMobileNumAndPanNum(pn.getName(), pn.getMobileNum(), pn.getPanNum());
		if(adh!=null && p!=null) {
			ad.setName(adh.getName());
			ad.setFatherName(adh.getFatherName());
			ad.setGender(adh.getGender());
			ad.setAddress(adh.getAddress());
			ad.setDob(adh.getDob());
			ad.setMobileNum(adh.getMobileNum());
			simp.UpdateCitizen(ad);
		}else {
			throw new Exception("User with aadhar number/PAN number not found"); 
		}	
		}
		
		@PutMapping("linkStatus")     //http://localhost:8080/aadhar/linkStatus
		@CrossOrigin(origins = "http://localhost:4200")
		public void checkLinkStatus(@RequestBody Aadhar ad) throws Exception {
			Aadhar a = simp.getAllCitizensByAadharNum(ad.getAadharNum());
			String pan1 = a.getPanNum();
			String pan2 = ad.getPanNum();
			if(pan1.equals(pan2)) {
				System.out.println("Linked");
			}else {
				throw new Exception("PAN card and Aadhar card are not linked"); 
			}
		}
}
