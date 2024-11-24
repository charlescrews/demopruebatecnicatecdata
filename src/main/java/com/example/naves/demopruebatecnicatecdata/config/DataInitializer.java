package main.java.com.example.naves.demopruebatecnicatecdata.config;

import com.example.spaceshipapi.model.Spaceship;
import com.example.spaceshipapi.repository.SpaceshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    @Bean
    @Profile("!prod")
    CommandLineRunner init(SpaceshipRepository repository) {
        return args -> {
            // Star Wars ships
            repository.save(createSpaceship("Millennium Falcon", "YT-1300", "Corellian Engineering Corporation", 4));
            repository.save(createSpaceship("X-Wing", "T-65B", "Incom Corporation", 1));
            repository.save(createSpaceship("TIE Fighter", "Twin Ion Engine", "Sienar Fleet Systems", 1));
            
            // Star Trek ships
            repository.save(createSpaceship("USS Enterprise", "Constitution Class", "Starfleet", 430));
            repository.save(createSpaceship("USS Voyager", "Intrepid Class", "Starfleet", 141));
            
            // Battlestar Galactica ships
            repository.save(createSpaceship("Galactica", "Battlestar", "Colonial Fleet", 5000));
            repository.save(createSpaceship("Viper", "Mark II", "Colonial Fleet", 1));
        };
    }

    private Spaceship createSpaceship(String name, String model, String manufacturer, int crew) {
        Spaceship ship = new Spaceship();
        ship.setName(name);
        ship.setModel(model);
        ship.setManufacturer(manufacturer);
        ship.setCrew(crew);
        return ship;
    }
}
