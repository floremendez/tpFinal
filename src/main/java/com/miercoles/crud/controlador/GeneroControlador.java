package com.miercoles.crud.controlador;

import com.miercoles.crud.modelo.Genero;
import com.miercoles.crud.servicio.GeneroServicioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/generos")
public class GeneroControlador {

    @Autowired
    private GeneroServicioInterfaz generoServicio;

    @GetMapping
    public String listarGeneros(Model modelo) {
        modelo.addAttribute("generos", generoServicio.obtenerTodos());
        return "generos/generos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoGenero(Model modelo) {
        modelo.addAttribute("genero", new Genero());
        return "generos/crear_genero";
    }

    @PostMapping
    public String guardarGenero(@ModelAttribute("genero") Genero genero) {
        generoServicio.guardar(genero);
        return "redirect:/generos/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarGenero(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("genero", generoServicio.obtenerPorId(id));
        return "generos/editar_genero";
    }

    @PostMapping("/{id}")
    public String actualizarGenero(@PathVariable Integer id, @ModelAttribute("genero") Genero genero) {
        genero.setId(id);
        generoServicio.guardar(genero);
        return "redirect:/generos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarGenero(@PathVariable Integer id) {
        generoServicio.eliminar(id);
        return "redirect:/generos";
    }
}
