package com.cine.crud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cine.crud.modelo.Genero;
import com.cine.crud.modelo.Pelicula;
import com.cine.crud.servicio.GeneroServicioInterfaz;
import com.cine.crud.servicio.PeliculaServicioInterfaz;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaControlador {

    @Autowired
    private PeliculaServicioInterfaz peliculaServicio;

    @Autowired
    private GeneroServicioInterfaz generoServicio;

    @GetMapping
    public String listarPeliculas(Model modelo) {
        List<Pelicula> peliculas = peliculaServicio.obtenerTodos();
        modelo.addAttribute("peliculas", peliculas);

        System.out.println("Películas cargadas:");
        peliculas.forEach(p -> System.out.println(p.getTitulo()));

        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("generos", generoServicio.obtenerTodos());
        return "peliculas/crear_pelicula";
    }

    @PostMapping
    public String guardarPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
        peliculaServicio.guardar(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Integer id, Model model) {
        Pelicula pelicula = peliculaServicio.obtenerPorId(id);

        if (pelicula == null) {
            return "redirect:/peliculas";
        }

        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoServicio.obtenerTodos());
        return "peliculas/crear_pelicula";
    }

    @PostMapping("/{id}")
    public String actualizarPelicula(@PathVariable Integer id, @ModelAttribute("pelicula") Pelicula pelicula) {
        pelicula.setId(id);
        peliculaServicio.guardar(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Integer id) {
        peliculaServicio.eliminar(id);
        return "redirect:/peliculas";
    }
}
