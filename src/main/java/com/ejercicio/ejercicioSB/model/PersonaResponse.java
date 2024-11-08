package com.ejercicio.ejercicioSB.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonaResponse {

    private int id;
    private String nombre;
    private int edad;
    private int idDepartamento;


}
