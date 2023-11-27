package com.myself.springsecurityjwt;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.SpringSecurityJWT.Controller.UserController;
import com.example.SpringSecurityJWT.Reository.ProductRepo;
import com.example.SpringSecurityJWT.Reository.UserRepo;
import com.example.SpringSecurityJWT.Model.User;

@RunWith(JUnit4.class)
class SpringsecurityjwtApplicationTests {

	@MockBean
	UserRepo repo;
	
	@Autowired
    UserController controller;
	
	
	@Test
     public void testProduct() {
    	 
     User user = new User();
     user.setUsername("Jeet");
     user.setRoles("Viewer");
     
     Mockito.when(repo.findByusername("Jeet")).thenReturn(user);
     
     assertNotNull(controller.findbyUserName("Jeet"));
     
     
     }

}
