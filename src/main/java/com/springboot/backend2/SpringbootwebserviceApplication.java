package com.springbootwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class SpringbootwebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebserviceApplication.class, args);
	}

}
