package com.miercoles.crud.controlador;

import com.miercoles.crud.modelo.Genero;
import com.miercoles.crud.modelo.Pelicula;
import com.miercoles.crud.servicio.GeneroServicioInterfaz;
import com.miercoles.crud.servicio.PeliculaServicioInterfaz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaControlador {

    @Autowired
    private PeliculaServicioInterfaz peliculaServicio;

    @Autowired
    private GeneroServicioInterfaz generoServicio;

    // Mostrar todas las películas
    @GetMapping
    public String listarPeliculas(Model modelo) {
        List<Pelicula> peliculas = peliculaServicio.obtenerTodos();
        modelo.addAttribute("peliculas", peliculas);

        System.out.println("Películas cargadas:");
        peliculas.forEach(p -> System.out.println(p.getTitulo()));

        return "index";
    }

    // Mostrar formulario de creación
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("generos", generoServicio.obtenerTodos());
        return "peliculas/crear_pelicula";
    }

    // Guardar nueva película
    @PostMapping
    public String guardarPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
        peliculaServicio.guardar(pelicula);
        return "redirect:/peliculas";
    }

    // Mostrar formulario de edición
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

    // Actualizar película existente
    @PostMapping("/{id}")
    public String actualizarPelicula(@PathVariable Integer id, @ModelAttribute("pelicula") Pelicula pelicula) {
        pelicula.setId(id);
        peliculaServicio.guardar(pelicula);
        return "redirect:/peliculas";
    }

    // Eliminar película
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Integer id) {
        peliculaServicio.eliminar(id);
        return "redirect:/peliculas";
    }
}
