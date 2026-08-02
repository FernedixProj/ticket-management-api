package com.fernedix.ticketmanagement.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ticketManagementOpenApi() {

        return new OpenAPI()

                .info(new Info()

                        .title("Ticket Management API")

                        .description("""
                                REST API built with Spring Boot 4.1.0 for event ticket management.
                                
                                This project demonstrates modern backend development practices,
                                including authentication, authorization, validation, auditing,
                                exception handling, mapping, and RESTful API design.
                                """)

                        .version("v1")

                        .contact(new Contact()
                                .name("Fernedix")
                                .url("https://github.com/FernedixProj")
                        )

                        .license(new License()
                                .name("MIT License")
                        )
                )

                .externalDocs(new ExternalDocumentation()

                        .description("Project Repository")

                        .url("https://github.com/FernedixProj/ticket-management-api"));
    }

}