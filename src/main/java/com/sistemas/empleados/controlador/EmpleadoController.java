package com.sistemas.empleados.controlador;

import com.sistemas.empleados.dominio.Empleado;
import com.sistemas.empleados.servicio.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/empleado", produces = "application/json")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity <List<Empleado>> getEmpleados() {
        return new ResponseEntity<>(
                empleadoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Empleado> getEmpleadoById(
            @PathVariable("id") Long id) {
        Empleado buscado = empleadoService.buscar(id);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(
                    new Empleado(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity <Empleado> crearEmpleado(
            @RequestBody Empleado empleado) {
        Empleado newEmpleado = empleadoService.agregar(empleado);
        return new ResponseEntity<>(newEmpleado, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity <Empleado> actualizarEmpleado(
            @RequestBody Empleado empleado) {
        Empleado putEmpleado = empleadoService.actualizar(empleado);
        return new ResponseEntity<>(putEmpleado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Empleado> eliminarEmpleado(
            @PathVariable("id") Long id) {
        empleadoService.eliminar(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
