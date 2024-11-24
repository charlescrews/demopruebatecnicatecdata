package main.java.com.example.naves.demopruebatecnicatecdata.exception;

public class SpaceshipNotFoundException extends RuntimeException {
    public SpaceshipNotFoundException(Long id) {
        super("No se encontró la nave espacial con ID: " + id);
    }
}