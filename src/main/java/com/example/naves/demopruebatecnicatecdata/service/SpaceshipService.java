package main.java.com.example.naves.demopruebatecnicatecdata.service;

import com.example.naves.demopruebatecnicatecdata.exception.SpaceshipNotFoundException;
import com.example.naves.demopruebatecnicatecdata.model.Spaceship;
import com.example.naves.demopruebatecnicatecdata.repository.SpaceshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SpaceshipService {

    private final SpaceshipRepository spaceshipRepository;

    public Page<Spaceship> findAll(Pageable pageable) {
        return spaceshipRepository.findAll(pageable);
    }

    @Cacheable(value = "spaceships", key = "#id")
    public Optional<Spaceship> findById(Long id) {
        return spaceshipRepository.findById(id);
    }

    public Page<Spaceship> findByNameContaining(String name, Pageable pageable) {
        return spaceshipRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Spaceship save(Spaceship spaceship) {
        return spaceshipRepository.save(spaceship);
    }

    @CacheEvict(value = "spaceships", key = "#id")
    public Optional<Spaceship> update(Long id, Spaceship spaceship) {
        return spaceshipRepository.findById(id)
            .map(existingSpaceship -> {
                existingSpaceship.setName(spaceship.getName());
                existingSpaceship.setModel(spaceship.getModel());
                existingSpaceship.setManufacturer(spaceship.getManufacturer());
                existingSpaceship.setCrew(spaceship.getCrew());
                return spaceshipRepository.save(existingSpaceship);
            });
    }

    @CacheEvict(value = "spaceships", key = "#id")
    public void delete(Long id) {
        spaceshipRepository.deleteById(id);
    }
}