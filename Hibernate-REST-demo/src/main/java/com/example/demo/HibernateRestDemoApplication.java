package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to run the application on the embedded Tomcat server.
 */
@SpringBootApplication
public class HibernateRestDemoApplication {

	/**
	 * Main method to run the application.
	 * 
	 * @param args contains any runtime arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(HibernateRestDemoApplication.class, args);
	}

}
