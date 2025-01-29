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
public class Voto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String email;

    public Voto() {
    }

    public Voto(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
