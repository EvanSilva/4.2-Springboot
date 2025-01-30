package edu.badpals.peliculas.controller;

import edu.badpals.peliculas.model.Pelicula;
import edu.badpals.peliculas.model.Voto;
import edu.badpals.peliculas.service.PeliculaRepository;
import edu.badpals.peliculas.service.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PeliculaController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private VotoRepository votoRepository;


    public void MovieController() {
    }

    @RequestMapping("/peliculas")
    public String enseñarPelicula(Model model) {

        List<Pelicula> peliculas = peliculaRepository.findAll();

        if (peliculas.isEmpty()) {
            peliculas.add(new Pelicula("https://lumiere-a.akamaihd.net/v1/images/image_51013278.jpeg"));
            peliculas.add(new Pelicula("https://es.web.img3.acsta.net/pictures/22/12/09/13/00/2030601.jpg"));
            peliculas.add(new Pelicula("https://hips.hearstapps.com/hmg-prod/images/las-aventuras-de-tintin-el-secreto-del-unicornio-66ca0a888dc8a.jpg"));

            for (Pelicula pelicula : peliculas) {
                peliculaRepository.save(pelicula);
            }

        }

        model.addAttribute("peliculas", peliculaRepository.findAll());

        return "peliculas";
    }

    @PostMapping("/sumarVoto")
    public String sumarVoto(@RequestParam("id") Long id, @RequestParam("email") String email, RedirectAttributes redirectAttributes) {

        System.out.println("Película seleccionada ID: " + id);
        System.out.println("Email ingresado: " + email);

        List<Voto> todosLosVotos = votoRepository.findAll();

        for (Voto voto : todosLosVotos) {
            if (voto.getEmail().equals(email)) {
                System.out.println("Detecta el voto repetido");

                redirectAttributes.addFlashAttribute("mensaje", "Ya has votado con este correo.");
                return "redirect:/peliculas";
            }
        }

        

        peliculaRepository.findById(id).ifPresent(pelicula -> {
            pelicula.sumarLike();
            peliculaRepository.save(pelicula);

            // Guardar el nuevo voto
            Voto votoNuevo = new Voto(email);
            votoRepository.save(votoNuevo);

        });
        return "redirect:/peliculas";  // Redirige a la página de películas después de sumar el voto
    }
}
