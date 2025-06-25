package com.cine.crud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cine.crud.modelo.Genero;
import com.cine.crud.servicio.GeneroServicioInterfaz;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

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
    public String guardarGenero(@Valid @ModelAttribute("genero") Genero genero,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "generos/crear_genero";
        }
        generoServicio.guardar(genero);
        return "redirect:/generos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarGenero(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("genero", generoServicio.obtenerPorId(id));
        return "generos/editar_genero";
    }

    @PostMapping("{id}")
    public String actualizarGenero(@Valid @ModelAttribute("genero") Genero genero,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "generos/editar_genero";
        }

        generoServicio.guardar(genero); // o actualizar si tenés lógica distinta
        return "redirect:/generos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarGenero(@PathVariable Integer id) {
        generoServicio.eliminar(id);
        return "redirect:/generos";
    }
}
