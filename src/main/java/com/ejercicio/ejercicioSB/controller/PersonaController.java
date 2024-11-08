package com.ejercicio.ejercicioSB.controller;

import com.ejercicio.ejercicioSB.entity.Departamento;
import com.ejercicio.ejercicioSB.entity.Persona;
import com.ejercicio.ejercicioSB.model.PersonaResponse;
import com.ejercicio.ejercicioSB.service.imp.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/personas")
    public List<PersonaResponse> readAll(){
        return personaService.readAll();
    }

    @GetMapping("/personas/{id}")
    public Persona readById(@PathVariable Integer id) {
        return personaService.readById(id);
    }

    @DeleteMapping("/persona/{id}")
    public String deletePersona(@PathVariable Integer id){
        return personaService.deleteById(id);
    }

}
