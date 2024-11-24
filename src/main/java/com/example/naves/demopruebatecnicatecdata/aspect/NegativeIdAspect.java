package main.java.com.example.naves.demopruebatecnicatecdata.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class NegativeIdAspect {

    @Before("execution(* com.example.spaceshipapi.service.SpaceshipService.findById(..)) && args(id)")
    public void logNegativeId(Long id) {
        if (id < 0) {
            log.warn("Se ha solicitado una nave con ID negativo: {}", id);
        }
    }
}