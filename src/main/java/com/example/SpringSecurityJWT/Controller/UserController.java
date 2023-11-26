package com.example.SpringSecurityJWT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurityJWT.Model.User;
import com.example.SpringSecurityJWT.Reository.UserRepo;
import com.example.SpringSecurityJWT.Reository.UserRepository;

@RestController
@RequestMapping("/user-service")
public class UserController {

	@Autowired
	UserRepo repo;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		
		return repo.save(user);
		
	}
	@GetMapping("/username/{name}")
	public User findbyUserName(String name) {
		
		return repo.findByusername(name);
	}
	@GetMapping("/allUsers")
	public List<User> findAllUsers() {
		return repo.findAll();
	}
}
