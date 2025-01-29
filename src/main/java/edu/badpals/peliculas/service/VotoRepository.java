package edu.badpals.peliculas.service;

import edu.badpals.peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface VotoRepository extends JpaRepository<Pelicula, Long> {
}
