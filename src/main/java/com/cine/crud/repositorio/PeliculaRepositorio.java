package com.cine.crud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.crud.modelo.Pelicula;

@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Integer> {
}
