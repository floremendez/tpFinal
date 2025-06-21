package com.miercoles.crud.servicio;

import com.miercoles.crud.modelo.Genero;
import com.miercoles.crud.repositorio.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServicio implements GeneroServicioInterfaz {

    @Autowired
    private GeneroRepositorio generoRepositorio;

    @Override
    public List<Genero> obtenerTodos() {
        return generoRepositorio.findAll();
    }

    @Override
    public Genero obtenerPorId(Integer id) {
        return generoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void guardar(Genero genero) {
        generoRepositorio.save(genero);
    }

    @Override
    public void eliminar(Integer id) {
        generoRepositorio.deleteById(id);
    }
}