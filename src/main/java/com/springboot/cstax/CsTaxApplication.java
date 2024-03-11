package com.springboot.cstax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.cstax.dto.PIPojo;

@SpringBootApplication
public class CsTaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsTaxApplication.class, args);
	}

	@Bean
	public PIPojo getPojo() {
		return new PIPojo();
	}
}