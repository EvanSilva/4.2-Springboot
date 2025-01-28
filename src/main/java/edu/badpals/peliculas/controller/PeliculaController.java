package edu.badpals.peliculas.controller;

import edu.badpals.peliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PeliculaController {

    @Autowired
    private edu.badpals.peliculas.repository.PeliculaRepository peliculaRepository;


    public void MovieController() {


    }

    @RequestMapping("/peliculas")
    public String enseñarPelicula(Model model) {

        List<Pelicula> peliculas = peliculaRepository.findAll();

        peliculas.add(new Pelicula("https://lumiere-a.akamaihd.net/v1/images/image_51013278.jpeg"));
        peliculas.add(new Pelicula("https://lumiere-a.akamaihd.net/v1/images/image_51013278.jpeg"));
        peliculas.add(new Pelicula("https://lumiere-a.akamaihd.net/v1/images/image_51013278.jpeg"));

        model.addAttribute("peliculas", peliculas);
        return "peliculas";
    }

    @PostMapping("/sumarVoto")
    public String añadirLike(@RequestParam("id") long id) {
        Pelicula pelicula = peliculaRepository.findById(id).orElse(null);
        if (pelicula != null) {
            pelicula.sumarLike();
            peliculaRepository.save(pelicula);
        }
        return "redirect:/peliculas";
    }
}
