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
        peliculas.add(new Pelicula("https://es.web.img3.acsta.net/pictures/22/12/09/13/00/2030601.jpg"));
        peliculas.add(new Pelicula("https://th.bing.com/th/id/R.2a21d39ba02e18cadb03c33f9b319b28?rik=gT2i5MuTfkmvvQ&riu=http%3a%2f%2fes.web.img3.acsta.net%2fpictures%2f15%2f10%2f02%2f15%2f52%2f201824.jpg&ehk=MmYLWiy2JScTAx25i2n2VJbkZKv7zFNpdlP3v4ePLYc%3d&risl=&pid=ImgRaw&r=0"));

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
