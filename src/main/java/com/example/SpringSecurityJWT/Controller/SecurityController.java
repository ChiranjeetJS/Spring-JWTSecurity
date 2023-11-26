package com.example.SpringSecurityJWT.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurityJWT.Exception.AccessRoleException;
import com.example.SpringSecurityJWT.Exception.InvalidUserException;
import com.example.SpringSecurityJWT.Exception.TokenExpiredException;
import com.example.SpringSecurityJWT.Model.JWTModel;
import com.example.SpringSecurityJWT.Model.Product;
import com.example.SpringSecurityJWT.Model.User;
import com.example.SpringSecurityJWT.Reository.ProductRepo;
import com.example.SpringSecurityJWT.Reository.ProductRepository;
import com.example.SpringSecurityJWT.Reository.UserRepo;
import com.example.SpringSecurityJWT.Reository.UserRepository;
import com.example.SpringSecurityJWT.Service.TokenManager;

@RestController
public class SecurityController {

	@Autowired
	TokenManager manager;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@GetMapping("/generateToken")
	public JWTModel  generateToken(@RequestHeader("name") String username) {
		
		return manager.generateToken(username);
	}
	
	@GetMapping("/getData")
	public String message(@RequestHeader("name") String name, @RequestHeader("token") String token) throws TokenExpiredException {
		
		if(manager.ValidateToken(token, name)) {
			return "Data returned";
		}
		else {
			return "Invalid token";
		}
		
	}
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product p,@RequestHeader String name,@RequestHeader String token) throws TokenExpiredException, AccessRoleException, InvalidUserException {
		
		
		
		
		
		if(!manager.ValidateToken(token, name)) {
			throw new InvalidUserException();
		}
		else if(manager.ValidateToken(token, name)) {
			User user = userRepo.findByusername(name);
			
			if(!user.getRoles().equals("ADMIN")) {
				throw new AccessRoleException();
			}
		}
		else {
			productRepo.save(p);
		}
		
		return new ResponseEntity<String>(p.toString(), HttpStatus.OK);
	}
	@GetMapping("/viewSoldProducts")
   public ResponseEntity<List<Product>> viewMostSoldProduct(@RequestHeader String name,@RequestHeader String token) throws InvalidUserException, AccessRoleException, TokenExpiredException {
		
		List<Product> product = new ArrayList<>();
		
		
	   if(!manager.ValidateToken(token, name)) {
			  
		   throw new InvalidUserException();
	   }
	    
	   else if(manager.ValidateToken(token, name)) {
		   
		User user = userRepo.findByusername(name);   
		
		if(user.getRoles().equals("MANAGER") || user.getRoles().equals("ADMIN")) {
			
			product = productRepo.findAll();
			
		}
		
		
	   }
		else {
			throw new AccessRoleException();
		}
	   
	  //Collections.sort(product);
	   
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
   
   @GetMapping("/viewProducts")
   public ResponseEntity<List<Product>> viewProduct(@RequestHeader String name,@RequestHeader String token) throws InvalidUserException, AccessRoleException, TokenExpiredException {
		
	   List<Product> product = new ArrayList<>();
	   

	   
	    if(!manager.ValidateToken(token, name)) {
		  
		   throw new InvalidUserException();
	   }
	  
	   else {
		
		   product = productRepo.findAll();
		   
		   for(Product p:product) {
			   p.setpQty(0);
			   p.setpSold(0);
		   }
	   }
	    
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
}
