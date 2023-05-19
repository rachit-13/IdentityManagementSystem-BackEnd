package com.example.demo.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Pan;

public interface PanRepository extends JpaRepository<Pan, String> {
	
	@Query("from Pan where panNum=?1")
	Pan findCitizenByPanNum(String panNum);
	
	Pan findByNameAndMobileNum(String name,String mobileNum);

	Pan findByNameAndMobileNumAndPanNum(String name, String mobileNum, String panNum);
	

}
