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
import com.example.demo.service.Service_Implementations;

@RestController
@RequestMapping("/pan")
public class PanController {
private Service_Implementations simp;
	
	@Autowired
	public PanController(Service_Implementations simp) {
		this.simp = simp;
	}
		
	
	
	@GetMapping("list")            //http://localhost:8080/pan/list
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Pan> getAllCitizens(){
		return simp.getAllCitizensP();
	}
	
	
	@GetMapping("list2/{panNum}")     //http://localhost:8080/pan/list2/
	@CrossOrigin(origins = "http://localhost:4200")
	public Pan getCitizensByPanNum(@PathVariable("panNum") String panNum) throws Exception{
		Pan p = null;
		p=simp.getAllCitizensByPanNum(panNum);
		if(p==null) {
			throw new Exception("User with pan number not found");
		}else {
			return simp.getAllCitizensByPanNum(panNum);
		}
	}
	
//	@GetMapping("list3/{name}")          //http://localhost:8080/aadhar/list3/Sumit Kumar
//	public List<Aadhar> getCitizenByName(@PathVariable("name") String name){
//		return simp.getRecordByCitizenName(name);
//	}
	
	@PostMapping("addCitizen")             //http://localhost:8080/pan/addCitizen
	@CrossOrigin(origins = "http://localhost:4200")
	public void addCitizenP(@RequestBody Pan p) throws Exception {
		Pan pan = null;
		pan = simp.fetchUserByNameAndMobileNum(p.getName(),p.getMobileNum());
		if(pan!=null) {
			throw new Exception("User with aadhar number not found");
		}else {
			p.setPanNum(generatePanNumber("AJGCSJ"));
			simp.insertCitizenP(p);
		}
	}
	
	@DeleteMapping("list/{panNum}")           //http://localhost:8080/pan/list/
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteCitizen(@PathVariable("panNum") String panNum)  {
			simp.DeleteCitizenByPanNum(panNum);
		}
	
	
	@PutMapping("list1")             //http://localhost:8080/pan/list1(pass panNum in body)
	@CrossOrigin(origins = "http://localhost:4200")
	public void updateCitizenDetails(@RequestBody Pan p) {
		simp.UpdateCitizenP(p);
	}
	
	public static String generatePanNumber(String name) {
		
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            char c = characters.charAt(random.nextInt(characters.length()));
            sb.append(c);
        }
        sb.append(name.toUpperCase().charAt(0) + "" + ((int)(Math.random()*9000)+1000));
        sb.append(characters.charAt(random.nextInt(characters.length())));
//        generatePanNum++;
        return sb.toString();
    }
	

}
