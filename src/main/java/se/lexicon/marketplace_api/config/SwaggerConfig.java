package se.lexicon.marketplace_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class SwaggerConfig {
        // Swagger configuration class
        // This class is used to configure Swagger for API documentation
        // It can include settings like API info, base package scanning, etc.

        @Bean
        public OpenAPI apiInfo() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Marketplace API")
                            .description("Spring Marketplace Application API Documentation")
                            .version("1.0.0")
                            .license(new License()
                                    .name("Apache 2.0")
                                    .url("http://springdoc.org")
                            )
                    );
        }
    }
