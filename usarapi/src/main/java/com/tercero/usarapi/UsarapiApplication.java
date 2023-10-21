package com.tercero.usarapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UsarapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsarapiApplication.class, args);
	}

}
