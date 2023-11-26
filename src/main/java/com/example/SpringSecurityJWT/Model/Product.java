package com.example.SpringSecurityJWT.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Product implements Comparable<Product> {
	@Id
	private UUID productId = UUID.randomUUID();
	private String pName;
	@Override
	public String toString() {
		return "productId=" + productId + ", pName=" + pName + ", pCost=" + pCost + ", pSold=" + pSold
				+ ", pQty="+pQty;
	}
	private int pCost;
	private int pSold;
	private int pQty;
	
	public UUID getproductId() {
		return productId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpCost() {
		return pCost;
	}
	public void setpCost(int pCost) {
		this.pCost = pCost;
	}
	public int getpSold() {
		return pSold;
	}
	public void setpSold(int pSold) {
		this.pSold = pSold;
	}
	public int getpQty() {
		return pQty;
	}
	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		if(pSold > o.getpSold()) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
	
	
	

}
