package com.cine.crud.servicio;

import java.util.List;

import com.cine.crud.modelo.Genero;

public interface GeneroServicioInterfaz {
    List<Genero> obtenerTodos();
    Genero obtenerPorId(Integer id);
    void guardar(Genero genero);
    void eliminar(Integer id);
}