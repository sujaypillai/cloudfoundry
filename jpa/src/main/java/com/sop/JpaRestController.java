package com.sop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaRestController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public String greeting(){
		return "Welcome to Spring Boot JPA Application";
	}
	
	@RequestMapping("/create")
	public String createUser(String email,String name){
		User user = null;
		try{
			user = new User(email, name);
			userDao.save(user);
		}catch(Exception e){
			return "Error creating user with email : " + email;
		}
		return "User created with following details : " + user.toString();
		
	}
}
