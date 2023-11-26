package com.example.SpringSecurityJWT.Reository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.SpringSecurityJWT.Model.User;

@Repository
public class UserRepository {
	
	private static List<User> userrepo = new ArrayList<User>();
	
	
     public User addUser(User user) {
    	 
    	 userrepo.add(user);
    	 
    	 return user;
    	 
     }
     
     public User getUser(String name) {
    	 
    	 for(User user:userrepo) {
    		 
    		 if(user.getUsername().equals(name)) {
    			 return user;
    		 }
    		 
    	 }
    	 return null;
     }

	public String getRole(String name) {
		// TODO Auto-generated method stub
		for(User user: userrepo) {
			if(user.getUsername().equals(name)) {
				return user.getRoles();
			}
		}
		return null;
	}
     
     
			

}
