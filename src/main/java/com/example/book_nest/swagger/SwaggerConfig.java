package com.example.book_nest.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name = "basicAuthentication", type = SecuritySchemeType.HTTP, scheme = "basic")
@OpenAPIDefinition(info = @Info(title = "Book Nest", version = "v1"))
public class SwaggerConfig {
}
