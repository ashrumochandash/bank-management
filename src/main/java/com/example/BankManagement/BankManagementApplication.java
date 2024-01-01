package com.example.BankManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BankManagementApplication extends SpringBootServletInitializer {
	
	 
	public static void main(String[] args) {
		SpringApplication.run(BankManagementApplication.class, args);
	}
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
       return application.sources(BankManagementApplication .class);
   }

}
