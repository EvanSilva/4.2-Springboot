package edu.badpals.peliculas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String url;

    private int likes = 0;

    public Pelicula(String url) {
        this.url = url;
    }

    public void sumarLike() {
        likes++;
    }

    public Pelicula() {
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getLikes() {
        return likes;
    }
}
