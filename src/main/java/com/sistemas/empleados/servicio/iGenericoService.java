package com.sistemas.empleados.servicio;

import java.util.List;

public interface iGenericoService <Dominio, ID> {
    public Dominio agregar(Dominio entidad);
    public List<Dominio> listarTodos();
    public Dominio buscar(ID id);
    public Dominio actualizar(Dominio entidad);
    public void eliminar(ID id);
}
