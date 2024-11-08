package com.ejercicio.ejercicioSB.service.imp;

import com.ejercicio.ejercicioSB.entity.Departamento;
import com.ejercicio.ejercicioSB.repository.DepartamentoRepository;
import com.ejercicio.ejercicioSB.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll().stream().filter(s ->s.getIsActive()).toList();
    }

    @Override
    public Departamento readById(Integer id) {

        Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
        if(departamentoOptional.isPresent()){
            return departamentoOptional.get();
        }else {
            return new Departamento();
        }

    }

    @Override
    public Departamento create(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento update(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public String deleteById(Integer id) {
       Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
       if (departamentoOptional.isPresent()){
           Departamento departamento = departamentoOptional.get();
           departamento.setIsActive(false);
           departamentoRepository.save(departamento);
           return "departamento borrado con exito";
       }else {
           return "El departamento no se encuentra";
       }
    }

    @Override
    public List<Departamento> findByPrecio(Double precio) {
        return departamentoRepository.findByPrecio(precio);
    }

    @Override
    public List<Departamento> findByPrecioLessThan(Double precio) {
        return departamentoRepository.findByPrecioLessThan(precio);
    }

    @Override
    public List<Departamento> findByPrecioAndM2(Double precio, Double m2) {
        return departamentoRepository.precioAndM2(precio,m2);
    }

    public int sumar(int a , int b){
        int resultado;
        resultado = a + b;

        return resultado;
    }
}
