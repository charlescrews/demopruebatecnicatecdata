package com.example.naves.demopruebatecnicatecdata;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableCaching
@EnableSpringDataWebSupport
@OpenAPIDefinition(
    info = @Info(
        title = "API de Naves Espaciales",
        version = "1.0",
        description = "API para gestionar naves espaciales de series y películas"
    )
)
public class SpaceshipApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceshipApiApplication.class, args);
    }

}
