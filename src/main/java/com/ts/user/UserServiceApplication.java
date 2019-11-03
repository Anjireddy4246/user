package com.ts.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		System.out.println("hello world. I have started initializing the application");
		SpringApplication.run(UserServiceApplication.class, args);
		System.out.println("Initialization is completed");
	}
}
