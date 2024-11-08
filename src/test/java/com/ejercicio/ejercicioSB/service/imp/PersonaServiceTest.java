package com.ejercicio.ejercicioSB.service.imp;

import com.ejercicio.ejercicioSB.entity.Departamento;
import com.ejercicio.ejercicioSB.entity.Persona;
import com.ejercicio.ejercicioSB.model.PersonaResponse;
import com.ejercicio.ejercicioSB.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {

    @InjectMocks
   private PersonaService personaService;

    @Mock
    private PersonaRepository personaRepository;

    @BeforeEach
    void setUp() {
        log.info("Setup before Method");
    }

    @AfterEach
    void tearDown() {
        log.info("Setup after Method");
    }

    //Departamento departamento = new Departamento(2,900.00,250000.00,true);

    @Test
    void readAll() {
        Persona persona = new Persona(1,"Juan Perez","Gardenia 23",34,true);
        Persona persona1 = new Persona(2,"Margarita","Girasoles 56", 21,true);
        List<Persona> personas = new ArrayList<>();
        personas.add(persona);
        personas.add(persona1);

        Mockito.when(personaRepository.findAll()).thenReturn(personas);

        List<PersonaResponse> listaEsperada = personaService.readAll();

        assertThat(listaEsperada).isEmpty();
        assertThat(listaEsperada.size()).isEqualTo(2);
        
    }

    @Test
    void readById() {
        Persona persona= new Persona(12,"Juan", "Amapola 222", 32,true);
        personaRepository.save(persona);
        when(personaRepository.findById(12)).thenReturn(Optional.of(persona));

        Persona personaGuardada = personaService.readById(persona.getId());

        assertThat(personaGuardada.getId()).isEqualTo(12);

    }

    @Test
    void create() {
        Persona persona= new Persona(12,"Juan", "Amapola 222", 32,true);
        personaService.create(persona);
        assertThat(persona).isNotNull();
        log.info("Persona creada");
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
       Persona persona = Persona.builder().id(5).nombre("Juan").direccion("Gardenias 34").edad(23).isActive(true).build();
       // Persona persona = new Persona(2,"Juan Carlos", "Azaleas 34",23,true);
        when(personaService.create(persona)).thenReturn(persona);
       // when(personaRepository.save(persona)).thenReturn(persona);
      // when(personaRepository.findById(4)).thenReturn(Optional.of(persona));
        when(personaService.deleteById(6));

        assertThat(persona).isNotNull();
        assertThat(persona.getIsActive()).isTrue();

    }
}