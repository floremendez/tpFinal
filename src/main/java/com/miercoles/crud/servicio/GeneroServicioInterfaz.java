package com.miercoles.crud.servicio;

import com.miercoles.crud.modelo.Genero;
import java.util.List;

public interface GeneroServicioInterfaz {
    List<Genero> obtenerTodos();
    Genero obtenerPorId(Integer id);
    void guardar(Genero genero);
    void eliminar(Integer id);
}