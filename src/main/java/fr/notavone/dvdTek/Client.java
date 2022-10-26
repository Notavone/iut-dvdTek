package fr.notavone.dvdTek;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final ArrayList<Location> locations;
    private final String nom;
    private final String prenom;
    private final String adresse;
    private final ArrayList<Film> filmsChoisis;

    public Client(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.locations = new ArrayList<>();
        filmsChoisis = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }
    public String getAdresse() { return adresse;}
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

    public void neChoisisPlus(Film film) {
        filmsChoisis.remove(film);
    }

    public void neChoisisPlus(List<Film> films) {
        if (films == filmsChoisis) films = new ArrayList<>(filmsChoisis);
        films.forEach(this::neChoisisPlus);
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
