package com.ejercicio.ejercicioSB.service;

import com.ejercicio.ejercicioSB.entity.Departamento;

import java.util.List;

public interface IDepartamentoService {
    public List<Departamento> readAll();
    public Departamento readById(Integer id);
    public Departamento create(Departamento departamento);
    public Departamento update(Departamento departamento);
    public String deleteById(Integer id);
    public List<Departamento> findByPrecio(Double precio);
    public List<Departamento> findByPrecioLessThan(Double precio);
    public List<Departamento> findByPrecioAndM2(Double precio, Double m2);
}
