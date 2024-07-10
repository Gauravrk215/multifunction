package com.niral.multithreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Main application class for the Spring Boot application.
 */
@EnableAsync
@SpringBootApplication
public class MultiThreadingApplication {

	
	 /**
     * The entry point of the application.
     *
     * @param args command line arguments
     */
	public static void main(String[] args) {
		SpringApplication.run(MultiThreadingApplication.class, args);
	}

}
