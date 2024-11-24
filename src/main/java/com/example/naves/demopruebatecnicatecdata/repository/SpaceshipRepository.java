package main.java.com.example.naves.demopruebatecnicatecdata.repository;

import com.example.naves.demopruebatecnicatecdata.model.Spaceship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
    Page<Spaceship> findByNameContainingIgnoreCase(String name, Pageable pageable);
}