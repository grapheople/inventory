package org.grapheople.inmaroom.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        String securityJwtName = "JWT";

        return new OpenAPI()
                .components(new io.swagger.v3.oas.models.Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Inmaroom API")
                        .description("Inmaroom API")
                        .version("1.0.0"));
    }
}
