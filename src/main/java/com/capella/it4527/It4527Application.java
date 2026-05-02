package com.capella.it4527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class It4527Application {

	@RequestMapping("/hello")
	public String helloWorld() { 
		return "Hello World"; 
	}
	
	int counter = 0;
	@RequestMapping("/counter")
	public int increment() {
		counter++;
		return counter;
	}


	public static void main(String[] args) {
		SpringApplication.run(It4527Application.class, args);
	}

}
