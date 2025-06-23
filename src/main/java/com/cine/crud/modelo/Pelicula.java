package com.cine.crud.modelo;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    @Column(name = "director", nullable = false, length = 30)
    private String director;

    @Column(name = "protagonista", nullable = false, length = 30)
    private String protagonista;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;


    

    public Pelicula() {}

    public Pelicula(String titulo, String director, String protagonista, Integer anio) {
        this.titulo = titulo;
        this.director = director;
        this.protagonista = protagonista;
        this.anio = anio;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
    public Genero getGenero() {
            return genero;
        }

        public void setGenero(Genero genero) {
            this.genero = genero;
        }


    @Override
    public String toString() {
        return "Pelicula{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
               ", director='" + director + '\'' +
               ", protagonista='" + protagonista + '\'' +
               ", anio=" + anio +
               '}';
    }
}
