package main.java.com.example.naves.demopruebatecnicatecdata.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI spaceshipOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Naves Espaciales")
                        .description("API para gestionar naves espaciales de series y películas")
                        .version("1.0"));
    }
}
