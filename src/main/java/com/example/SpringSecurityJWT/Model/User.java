package com.example.SpringSecurityJWT.Model;

import java.util.UUID;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
	public UUID getuserId() {
		return userId;
		
	}
	@Id
	private UUID userId = UUID.randomUUID();
	private String username;
	private String roles;
}
