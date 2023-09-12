package com.springboot.blog;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Blog REST API",
				description = "Spring Boot Blog REST API Documentation",
				version = "v1.0.0",
				contact = @Contact(
						name = "JaeHwan",
						email = "wpghks56@naver.com",
						url = "https://github.com/dbwpghks56"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/dbwpghks56"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Blog REST API Repository",
				url = "https://github.com/dbwpghks56/springboot-blog-rest-api"
		)
)
public class SpringbootBlogRestApiApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

}
