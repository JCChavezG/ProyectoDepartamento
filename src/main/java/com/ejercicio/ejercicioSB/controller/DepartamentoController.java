package com.ejercicio.ejercicioSB.controller;

import com.ejercicio.ejercicioSB.entity.Departamento;
import com.ejercicio.ejercicioSB.service.imp.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/departamentos")
    public List<Departamento> readAll() {
        return departamentoService.readAll();
    }

    @GetMapping("/departamentos/{id}")
    public Departamento readById(@PathVariable Integer id) {
        return departamentoService.readById(id);
    }

    @GetMapping("/departamento/Precio")
    public List<Departamento> findByPrecio(@RequestParam Double precio){
        return departamentoService.findByPrecio(precio);
    }

    @GetMapping("/departamento/lowerPrecio")
    public List<Departamento> findByPrecioLessThan(@RequestParam Double precio){
        return departamentoService.findByPrecioLessThan(precio);
    }

    @GetMapping("/departamento/precioM2")
    public List<Departamento> findByPrecioAndM2(@RequestParam Double precio, @RequestParam Double m2){
        return departamentoService.findByPrecioAndM2(precio, m2);
    }

    @DeleteMapping ("/departamentos/{id}")
    public String deleteById(@PathVariable Integer id) {
        return departamentoService.deleteById(id);
    }


}
