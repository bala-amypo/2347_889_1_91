package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI maintenanceApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Maintenance Ticket Root Cause API")
                        .description("Categorization & urgency engine")
                        .version("1.0"));
    }
}
