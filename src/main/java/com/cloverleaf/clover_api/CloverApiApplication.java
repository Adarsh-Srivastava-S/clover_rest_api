package com.cloverleaf.clover_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.cloverleaf.clover_api") // Adjust the package name accordingly

public class CloverApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(CloverApiApplication.class, args);
		System.out.println("Backend Running.....");
	}

}
