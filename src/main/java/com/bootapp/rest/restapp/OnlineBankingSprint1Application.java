package com.bootapp.rest.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class OnlineBankingSprint1Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingSprint1Application.class, args);
	}

}
