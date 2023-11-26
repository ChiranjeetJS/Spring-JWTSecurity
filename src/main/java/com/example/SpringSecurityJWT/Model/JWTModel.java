package com.example.SpringSecurityJWT.Model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringSecurityJWT.Service.TokenManager;

public class JWTModel {
	
	@Autowired
	TokenManager manager;

	private String token;
	private Long issuedAt;
	private Long expiresAt;
	
	
	public Long getIssuedAt() {
		return  issuedAt;
	}
	public void setIssuedAt(Long issuedAt) {
		this.issuedAt = issuedAt;
	}
	public Long getExpiresAt() {
		return  expiresAt;
	}
	public void setExpiresAt(Long expiresAt) {
		this.expiresAt = expiresAt;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	
	
	
}
