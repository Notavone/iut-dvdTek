package fr.notavone.dvdTek;

import java.util.ArrayList;

public class Rayon {
    private final ArrayList<Film> films;

    public Rayon(ArrayList<Film> films) {
        this.films = films;
    }

    public Rayon() {
        this(new ArrayList<Film>());
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void ajouterFilm(Film film) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
