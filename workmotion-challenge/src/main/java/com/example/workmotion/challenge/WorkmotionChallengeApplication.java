package com.example.workmotion.challenge;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee Service API", version = "2.0", description = "Employees Information & State Processing"))
public class WorkmotionChallengeApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkmotionChallengeApplication.class, args);
	}

}
