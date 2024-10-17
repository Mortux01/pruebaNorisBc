package com.noris.prueba.bci.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "pruebanorisbci",
                version = "1.0.0",
                description = "Esta es una prueba tecnica para bci"
        )

)
public class SwaggerConfig {




}
