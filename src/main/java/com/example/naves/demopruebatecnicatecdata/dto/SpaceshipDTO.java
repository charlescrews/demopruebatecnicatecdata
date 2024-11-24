package main.java.com.example.naves.demopruebatecnicatecdata.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SpaceshipDTO {
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    
    @NotBlank(message = "El modelo es obligatorio")
    private String model;
    
    @NotBlank(message = "El fabricante es obligatorio")
    private String manufacturer;
    
    @NotNull(message = "La tripulación es obligatoria")
    @Min(value = 1, message = "La tripulación debe ser al menos 1")
    private Integer crew;
}
