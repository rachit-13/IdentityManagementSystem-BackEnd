package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.Service_Implementations;

@RestController
public class RegistrationController {

	@Autowired
	
	private Service_Implementations serimp;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId))
		{
			user.setRole("user");
			User userObj = serimp.fetchUserByEmailId(tempEmailId);
			if(userObj != null)
				throw new Exception("User with "+tempEmailId+" already exist");
		}
		
		User userObj = null;
		userObj = serimp.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		String tempRole = "user";
		User userObj = null;
		if(tempEmailId != null && tempPassword != null && (tempRole != null && tempRole.equalsIgnoreCase("user")))
		{
			userObj = serimp.fetchUserByEmailIdAndPasswordAndRole(tempEmailId, tempPassword, tempRole);
		}
		if(userObj == null)
			throw new Exception("User not registered!");
		return userObj;
	}
	
	
	@PostMapping("/loginadmin")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginAdmin(@RequestBody User user) throws Exception
	{
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		String tempRole = "admin";
		User userObj = null;
		if(tempEmailId != null && tempPassword != null && (tempRole != null && tempRole.equalsIgnoreCase("admin")))
		{
			userObj = serimp.fetchUserByEmailIdAndPasswordAndRole(tempEmailId, tempPassword, tempRole);
		}
		if(userObj == null)
			throw new Exception("User not registered!");
		return userObj;
	}
	
}