package com.example.demo.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {

		public User findByEmailId(String email);
		
		public User findByEmailIdAndPasswordAndRole(String email, String password, String role);


}