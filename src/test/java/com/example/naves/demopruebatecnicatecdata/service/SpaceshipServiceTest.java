package test.java.com.example.naves.demopruebatecnicatecdata.service;

import main.java.com.example.naves.demopruebatecnicatecdata.model.Spaceship;
import main.java.com.example.naves.demopruebatecnicatecdata.repository.SpaceshipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpaceshipServiceTest {

    @Mock
    private SpaceshipRepository spaceshipRepository;

    @InjectMocks
    private SpaceshipService spaceshipService;

    private Spaceship spaceship;

    @BeforeEach
    void setUp() {
        spaceship = new Spaceship();
        spaceship.setId(1L);
        spaceship.setName("X-Wing");
        spaceship.setModel("T-65");
        spaceship.setManufacturer("Incom Corporation");
        spaceship.setCrew(1);
    }

    @Test
    void whenFindById_thenReturnSpaceship() {
        when(spaceshipRepository.findById(1L)).thenReturn(Optional.of(spaceship));

        Optional<Spaceship> found = spaceshipService.findById(1L);

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo(spaceship.getName());
    }

    @Test
    void whenFindByNameContaining_thenReturnPageOfSpaceships() {
        Page<Spaceship> page = new PageImpl<>(List.of(spaceship));
        Pageable pageable = PageRequest.of(0, 10);
        
        when(spaceshipRepository.findByNameContainingIgnoreCase(any(), any()))
            .thenReturn(page);

        Page<Spaceship> found = spaceshipService.findByNameContaining("wing", pageable);

        assertThat(found.getContent()).hasSize(1);
        assertThat(found.getContent().get(0).getName()).isEqualTo(spaceship.getName());
    }
}
