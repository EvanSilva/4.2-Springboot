package edu.badpals.peliculas.controller;

import edu.badpals.peliculas.model.Pelicula;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

public class PeliculaController implements WebMvcConfigurer {

    private final List<Pelicula> peliculas = new ArrayList<>();

    public void MovieController() {

        peliculas.add(new Pelicula("https://i.ebayimg.com/images/g/6RcAAOSwTPdnLrTA/s-l1600.webp"));
        peliculas.add(new Pelicula("https://i.ebayimg.com/images/g/6RcAAOSwTPdnLrTA/s-l1600.webp"));
        peliculas.add(new Pelicula("https://i.ebayimg.com/images/g/6RcAAOSwTPdnLrTA/s-l1600.webp"));


    }

    @RequestMapping("/peliculas")
    public String enseñarPelicula(Model model) {
        model.addAttribute("peliculas", peliculas);
        return "peliculas";
    }

    @PostMapping("/sumarVoto")

    public String añadirLike(@RequestParam("id") int id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                pelicula.sumarLike();
                break;
            }
        }
        return "redirect:/peliculas";
    }
}
