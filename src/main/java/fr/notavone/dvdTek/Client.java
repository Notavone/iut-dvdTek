package fr.notavone.dvdTek;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final ArrayList<Location> locations;
    private final String nom;
    private final String prenom;
    private final ArrayList<Film> filmsChoisis;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.locations = new ArrayList<>();
        filmsChoisis = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public List<Rayon> visiter(Boutique boutique) {
        return boutique.getRayons();
    }

    public List<Film> observer(Rayon rayon) {
        return rayon.getFilms();
    }

    public void choisis(Film film) {
        if (!filmsChoisis.contains(film)) filmsChoisis.add(film);
    }

    public void choisis(List<Film> films) {
        for (Film f : films) choisis(f);
    }

    public Location louer(List<Film> films, int nbJours) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Location louer(Film film, int nbJours) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Facture retourner(Location location) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Film> getFilmsChoisis() {
        return filmsChoisis;
    }
}
