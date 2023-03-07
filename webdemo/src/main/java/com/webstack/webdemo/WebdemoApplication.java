package com.webstack.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebdemoApplication {

	@GetMapping("/")
	public String sayHello() {
		return "Hello Radhe Krishna...!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebdemoApplication.class, args);
	}

}
