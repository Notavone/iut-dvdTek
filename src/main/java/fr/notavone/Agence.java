package fr.notavone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agence {
    private final String nom;
    private final List<Film> films;

    public Agence(String nom, List<Film> films) {
        this.nom = nom;
        this.films = films;
    }

    public Agence(String nom) {
        this(nom, new ArrayList<>());
    }

    public String getNom() {
        return nom;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void ajouterFilm(Film... film) {
        Collections.addAll(films, film);
    }

    public void retirerFilm(Film... film) {
        for (Film f : film) {
            films.remove(f);
        }
    }
}
