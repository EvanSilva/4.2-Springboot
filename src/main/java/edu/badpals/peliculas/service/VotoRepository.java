package edu.badpals.peliculas.service;

import edu.badpals.peliculas.model.Pelicula;
import edu.badpals.peliculas.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {


    public Voto findByEmail(String email);

}
