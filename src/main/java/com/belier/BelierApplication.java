package com.belier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BelierApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(BelierApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
