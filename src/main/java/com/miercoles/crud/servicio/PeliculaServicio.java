package com.miercoles.crud.servicio;

import com.miercoles.crud.modelo.Pelicula;
import com.miercoles.crud.repositorio.PeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServicio implements PeliculaServicioInterfaz {

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    @Override
    public List<Pelicula> obtenerTodos() {
        return peliculaRepositorio.findAll();
    }


    @Override
    public Pelicula obtenerPorId(Integer id) {
        return peliculaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        peliculaRepositorio.save(pelicula);
    }

    @Override
    public void eliminar(Integer id) {
        peliculaRepositorio.deleteById(id);
    }
}