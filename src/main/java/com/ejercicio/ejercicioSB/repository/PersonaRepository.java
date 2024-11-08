package com.ejercicio.ejercicioSB.repository;

import com.ejercicio.ejercicioSB.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {

}
