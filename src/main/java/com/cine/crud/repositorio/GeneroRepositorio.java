package com.cine.crud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.crud.modelo.Genero;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Integer> {
}
