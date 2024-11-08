package com.ejercicio.ejercicioSB.service.imp;

import com.ejercicio.ejercicioSB.entity.Departamento;
import com.ejercicio.ejercicioSB.repository.DepartamentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {

    @InjectMocks
    DepartamentoService departamentoService;

    @Mock
    DepartamentoRepository departamentoRepository;

    private Departamento departamento;


    @BeforeEach
    void setUp() {
        log.info("Setup before Method");
    }

    @AfterEach
    void tearDown() {
        log.info("Setup after Method");
    }

    @Test
    void sumar() {
        int suma = departamentoService.sumar(2, 5);
        assertEquals(7, suma);
        log.info("Metodo sumar departamento");
    }


    @DisplayName("Test para crear Departamento")
    @Test
    void create() {
        Departamento departamento = new Departamento(2,900.00, 250000.00,true);
        departamentoService.create(departamento);
        assertThat(departamento).isNotNull();
        log.info("Departamento creado");


    }


    @Test
    void testDeleteById() {
        Departamento departamento = new Departamento(2,900.00, 250000.00,true);
        when(departamentoRepository.findById(2)).thenReturn(Optional.of(departamento));
        when(departamentoRepository.save(departamento)).thenReturn(departamento);
        when(departamentoService.deleteById(departamento.getId())).thenReturn(String.valueOf(departamento));

        assertThat(departamento.getIsActive()).isFalse();
        log.info("Departamento borrado");
    }


    @Test
    void findByPrecio() {
        Departamento departamento = new Departamento(22,900.00, 250000.00,true);
     //  Departamento departamento1 = new Departamento(23,800.00,345000.00,true);
        //  Departamento departamento2 = new Departamento(24,900.00,260000.00,true);

       assertThat(departamentoService.findByPrecio(250000.00));




    }

    @Test
    void readById() {

        Departamento departamento = new Departamento(22,900.00, 250000.00,true);

        when(departamentoRepository.findById(22)).thenReturn(Optional.of(departamento));

       Departamento departamentoGuardado = departamentoService.readById(departamento.getId());

        assertThat(departamentoGuardado).isNotNull();
    }

    @Test
    void update() {
        Departamento departamento = new Departamento(22,900.00, 250000.00,true);
       departamentoRepository.save(departamento);

       Departamento departamento1 = new Departamento(22,909.00,251000.00,true);


       departamento.setM2(departamento1.getM2());
       departamento.setPrecio(departamento1.getPrecio());


        Departamento departamentoActualizado = departamentoRepository.save(departamento);

        assertThat(departamentoActualizado.getPrecio()).isEqualTo(251000.00);
        assertThat(departamentoActualizado.getM2()).isEqualTo(909.00);
    }

    @Test
    void readAll() {
    }
}