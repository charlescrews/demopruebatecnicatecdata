package test.java.com.example.naves.demopruebatecnicatecdata.controller;

import main.java.com.example.naves.demopruebatecnicatecdata.dto.SpaceshipDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpaceshipControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void whenCreateSpaceship_thenStatus201() throws Exception {
        SpaceshipDTO dto = new SpaceshipDTO();
        dto.setName("Millennium Falcon");
        dto.setModel("YT-1300");
        dto.setManufacturer("Corellian Engineering Corporation");
        dto.setCrew(4);

        mockMvc.perform(post("/api/spaceships")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(dto.getName()));
    }

    @Test
    @WithMockUser
    void whenGetSpaceship_thenStatus200() throws Exception {
        mockMvc.perform(get("/api/spaceships/{id}", 1))
                .andExpect(status().isOk());
    }
}
