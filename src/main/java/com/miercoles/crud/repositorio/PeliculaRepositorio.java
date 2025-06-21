package com.miercoles.crud.repositorio;

import com.miercoles.crud.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Integer> {
}
