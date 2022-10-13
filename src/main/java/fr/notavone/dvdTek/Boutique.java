package fr.notavone.dvdTek;

import java.util.ArrayList;
import java.util.List;

public class Boutique {
    private final ArrayList<Rayon> rayons;

    public Boutique(ArrayList<Rayon> rayons) {
        this.rayons = rayons;
    }

    public ArrayList<Rayon> getRayons() {
        return rayons;
    }

    public boolean verifierDisponibilite(Film film) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Film> verifierDisponibilite(List<Film> films) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
