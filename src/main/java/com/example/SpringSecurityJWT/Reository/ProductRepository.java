package com.example.SpringSecurityJWT.Reository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.SpringSecurityJWT.Model.Product;


@Repository
public class ProductRepository {

	
	private static List<Product> productRepo = new ArrayList<>();
	
	
	public Product addProduct(Product product) {
		
		productRepo.add(product);
		
		return product;
		
	}
	
	public List<Product> mostSoldProducts(){
		
		Collections.sort(productRepo);
		
		return productRepo;
		
	}
	
	
    public List<Product> availableProducts(){
    	
    	List<Product> product = new ArrayList<>();
    	
    	for(Product p:productRepo) {
    		if(p.getpQty()>0) {
    			p.setpSold(0);
    			product.add(p);
    		}
    	}
    	
    	return product;
    }
	

	
}
