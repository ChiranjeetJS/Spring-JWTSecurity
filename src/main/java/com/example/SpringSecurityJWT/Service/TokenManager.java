package com.example.SpringSecurityJWT.Service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.SpringSecurityJWT.Exception.TokenExpiredException;
import com.example.SpringSecurityJWT.Model.JWTModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenManager {
	
	String secretkey = "abc123";
	public JWTModel generateToken(String username){
		
		HashMap<String,Object> claims = new HashMap<String,Object>();
		
	String token = 	Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
		.signWith(SignatureAlgorithm.HS256,secretkey).compact();
	
	JWTModel model = new JWTModel();
	model.setToken(token);
    model.setIssuedAt((System.currentTimeMillis())/1000);
    model.setExpiresAt((System.currentTimeMillis()+1000*60*60)/1000);   
	return model;
		
	}
	
	public Date getIsuedDate(String token) {
		
		Claims claims = (Claims) Jwts.parser().parseClaimsJws(token).getBody();
	   
		return claims.getIssuedAt();
	}
	
      public Date getExpiredDate(String token) {
		
		Claims claims = (Claims) Jwts.parser().setSigningKey(secretkey).parse(token).getBody();
	   
		return claims.getExpiration();
	}
	
	public boolean ValidateToken(String token,String username) throws TokenExpiredException {
		
		
		Claims claims = (Claims) Jwts.parser().setSigningKey(secretkey).parse(token).getBody();
		
		if(claims.getExpiration().before(new Date(System.currentTimeMillis()))) {
			throw new TokenExpiredException();
		}
		
		else if(claims.getSubject().equals(username)){
			return true;
		}
		
		return false;
		
	}

}
