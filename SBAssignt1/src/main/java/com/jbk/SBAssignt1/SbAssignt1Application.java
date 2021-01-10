package com.jbk.SBAssignt1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin

@ComponentScan("com.jbk")
@SpringBootApplication
public class SbAssignt1Application {

	public static void main(String[] args) {
		SpringApplication.run(SbAssignt1Application.class, args);
	}

}
