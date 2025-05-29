package com.anish.expensemanager.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Smart Expense Manager API")
                        .description("Track your income, expenses and view analytics.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Anish Chauhan")
                                .email("anish5sep@gmail.com")
                                .url("https://github.com/anish5sep/expensemanager")
                        )
                );
    }
}
