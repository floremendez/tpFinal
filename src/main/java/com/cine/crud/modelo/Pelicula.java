package com.cine.crud.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 40, message = "El título no puede superar los 40 caracteres")
    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    @NotBlank(message = "El director es obligatorio")
    @Size(max = 30, message = "El director no puede superar los 30 caracteres")
    @Column(name = "director", nullable = false, length = 30)
    private String director;

    @NotBlank(message = "El protagonista es obligatorio")
    @Size(max = 30, message = "El protagonista no puede superar los 30 caracteres")
    @Column(name = "protagonista", nullable = false, length = 30)
    private String protagonista;

    @NotNull(message = "El año es obligatorio")
    @Min(value = 1888, message = "El año debe ser posterior a 1888")
    @Max(value = 2100, message = "El año no puede superar 2100")
    private Integer anio;

    @NotNull(message = "Debe seleccionar un género")
    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;

    public Pelicula() {
    }

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
