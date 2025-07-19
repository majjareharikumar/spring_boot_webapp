package com.javaguide.Spring_boot_restful_webservices;


import com.javaguide.Spring_boot_restful_webservices.entity.User;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring boot Restful API",
				description = "Spring boot Restful API Documentation",
				version = "V1.0",
				contact = @Contact(
						name = "Hari",
						email = "Hari123@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.javatech.com/licens"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot user management doc",
				url = "https://www.javatech.com/user_management.html"
		)
)
public class SpringBootRestfulWebservicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootRestfulWebservicesApplication.class, args);


	}

}
