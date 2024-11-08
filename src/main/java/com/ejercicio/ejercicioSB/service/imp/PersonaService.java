package com.ejercicio.ejercicioSB.service.imp;

import com.ejercicio.ejercicioSB.entity.Persona;
import com.ejercicio.ejercicioSB.model.PersonaResponse;
import com.ejercicio.ejercicioSB.repository.PersonaRepository;
import com.ejercicio.ejercicioSB.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<PersonaResponse> readAll() {
        List<Persona> listaPersonas = personaRepository.findAll();
        List<PersonaResponse> listaResultado = listaPersonas.stream().map(s ->
        {
            PersonaResponse personaResponse = new PersonaResponse();
            personaResponse.setId(s.getId());
            personaResponse.setNombre(s.getNombre());
            personaResponse.setEdad(s.getEdad());
            personaResponse.setIdDepartamento(s.getIdDepartamento().getId());
            return personaResponse;
        }).toList();
        return listaResultado ;
    }

    @Override
    public Persona readById(Integer id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if(personaOptional.isPresent()){
            personaOptional.get();
        }else {
            return personaOptional.orElse(null);
        }

        return null;
    }

    @Override
    public Persona create(Persona persona) {
        return personaRepository.save(persona);

    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public String deleteById(Integer id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if(personaOptional.isPresent()){
            Persona persona = personaOptional.get();
            persona.setIsActive(false);
            personaRepository.save(persona);
            return "Persona guardada con exito";
        } else {
            return "Persona no encontrada";
        }

    }
}
