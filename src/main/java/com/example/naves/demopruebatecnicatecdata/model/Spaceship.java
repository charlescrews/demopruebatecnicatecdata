package main.java.com.example.naves.demopruebatecnicatecdata.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "spaceships")
public class Spaceship {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String model;
    
    private String manufacturer;
    
    private Integer crew;
}
