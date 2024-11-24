package main.java.com.example.naves.demopruebatecnicatecdata.mapper;

import main.java.com.example.naves.demopruebatecnicatecdata.dto.SpaceshipDTO;
import main.java.com.example.naves.demopruebatecnicatecdata.model.Spaceship;
import org.springframework.stereotype.Component;

@Component
public class SpaceshipMapper {
    
    public SpaceshipDTO toDTO(Spaceship spaceship) {
        SpaceshipDTO dto = new SpaceshipDTO();
        dto.setId(spaceship.getId());
        dto.setName(spaceship.getName());
        dto.setModel(spaceship.getModel());
        dto.setManufacturer(spaceship.getManufacturer());
        dto.setCrew(spaceship.getCrew());
        return dto;
    }
    
    public Spaceship toEntity(SpaceshipDTO dto) {
        Spaceship spaceship = new Spaceship();
        spaceship.setId(dto.getId());
        spaceship.setName(dto.getName());
        spaceship.setModel(dto.getModel());
        spaceship.setManufacturer(dto.getManufacturer());
        spaceship.setCrew(dto.getCrew());
        return spaceship;
    }
}
