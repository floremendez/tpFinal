package com.miercoles.crud.servicio;

import com.miercoles.crud.modelo.Pelicula;
import java.util.List;

public interface PeliculaServicioInterfaz {
    List<Pelicula> obtenerTodos();
    Pelicula obtenerPorId(Integer id);
    void guardar(Pelicula pelicula);
    void eliminar(Integer id);
}