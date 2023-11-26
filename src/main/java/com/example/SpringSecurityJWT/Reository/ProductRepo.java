package com.example.SpringSecurityJWT.Reository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurityJWT.Model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {

}
