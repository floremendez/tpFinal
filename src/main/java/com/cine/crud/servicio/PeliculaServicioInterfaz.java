package com.cine.crud.servicio;

import java.util.List;

import com.cine.crud.modelo.Pelicula;

public interface PeliculaServicioInterfaz {
    List<Pelicula> obtenerTodos();
    Pelicula obtenerPorId(Integer id);
    void guardar(Pelicula pelicula);
    void eliminar(Integer id);
}