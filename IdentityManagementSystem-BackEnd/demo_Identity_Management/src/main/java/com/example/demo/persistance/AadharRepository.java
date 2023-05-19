package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Aadhar;

public interface AadharRepository extends JpaRepository<Aadhar, Long>{
	
	@Query("from Aadhar where aadharNum=?1")
	Aadhar findCitizenByaadharNum(String aadharNum);
	
	@Query("from Aadhar where name=?1")
	List<Aadhar> searchCitizenByName(String name);

	
	void deleteByAadharNum(String aadharNum);

	Aadhar findByNameAndMobileNumAndAadharNum(String name, String mobileNum, String aadharNum);

	Aadhar findByNameAndMobileNum(String name, String mobileNum);

}
