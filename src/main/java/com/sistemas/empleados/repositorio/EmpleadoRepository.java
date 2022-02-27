package com.sistemas.empleados.repositorio;

import com.sistemas.empleados.dominio.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
