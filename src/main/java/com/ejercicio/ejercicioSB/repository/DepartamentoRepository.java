package com.ejercicio.ejercicioSB.repository;

import com.ejercicio.ejercicioSB.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    public List<Departamento> findByPrecio(Double precio);
    public List<Departamento> findByPrecioLessThan(Double precio);
    @Query(value = "select * from departamento where m2>=:m2 and precio>=:precio;", nativeQuery = true)
    public List<Departamento> precioAndM2(Double precio, Double m2);
}
