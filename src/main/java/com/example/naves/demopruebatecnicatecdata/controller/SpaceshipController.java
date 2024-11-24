package main.java.com.example.naves.demopruebatecnicatecdata.controller;

import com.example.naves.demopruebatecnicatecdata.model.Spaceship;
import com.example.naves.demopruebatecnicatecdata.service.SpaceshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spaceships")
@RequiredArgsConstructor
@Tag(name = "Spaceship", description = "API de gestión de naves espaciales")
public class SpaceshipController {

    private final SpaceshipService spaceshipService;
    private final SpaceshipMapper spaceshipMapper;

    @GetMapping
    @Operation(summary = "Obtener todas las naves espaciales")
    @Timed(value = "spaceship.findAll", description = "Tiempo para obtener todas las naves")
    public Page<SpaceshipDTO> getAllSpaceships(Pageable pageable) {
        return spaceshipService.findAll(pageable)
                .map(spaceshipMapper::toDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una nueva nave espacial")
    public SpaceshipDTO createSpaceship(@Valid @RequestBody SpaceshipDTO spaceshipDTO) {
        Spaceship spaceship = spaceshipMapper.toEntity(spaceshipDTO);
        return spaceshipMapper.toDTO(spaceshipService.save(spaceship));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Spaceship> updateSpaceship(@PathVariable Long id, @RequestBody Spaceship spaceship) {
        return spaceshipService.update(id, spaceship)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpaceship(@PathVariable Long id) {
        spaceshipService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
