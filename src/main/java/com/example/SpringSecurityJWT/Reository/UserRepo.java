package com.example.SpringSecurityJWT.Reository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurityJWT.Model.User;
@Repository
public interface UserRepo extends JpaRepository<User,UUID>{

	public User findByusername(String name);
}
