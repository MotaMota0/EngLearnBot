package com.ara.EnglishBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class EnglishBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishBotApplication.class, args);
	}

}
