package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Exemple API REST", version = "2.0", description = "Exemple Spring Boot Data MongoDB"))
public class SpringBootDataRestApiMongodbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataRestApiMongodbExampleApplication.class, args);
	}

}
