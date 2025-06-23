package com.cine.crud.modelo;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @OneToMany(mappedBy = "genero")
    private List<Pelicula> peliculas;

    public Genero() {}
    public Genero(String nombre) {
        this.nombre=nombre;
    }
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}