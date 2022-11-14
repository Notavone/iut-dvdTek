package fr.notavone;

import fr.notavone.exceptions.FilmIndisponibleException;
import fr.notavone.exceptions.SoldeInsuffisantException;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private final List<Location> listeLocations = new ArrayList<>();
    private final String nom;
    private final ComptePrepaye comptePrepaye;

    public Client(String nom) {
        this.nom = nom;
        this.comptePrepaye = new ComptePrepaye();
    }

    public String getNom() {
        return nom;
    }

    public List<Location> getListeLocations() {
        return listeLocations;
    }

    public Location louerFilms(Agence agence, List<Film> films, int duree, MoyenPaiement moyenPaiement) throws FilmIndisponibleException, SoldeInsuffisantException {
        boolean contientIndisponible = agence.getFilms().stream().anyMatch(film -> film.getLocation() != null);
        if (contientIndisponible) {
            throw new FilmIndisponibleException();
        }

        Location location = new Location(this, agence, films, duree, moyenPaiement);
        location.facturer();

        this.listeLocations.add(location);

        for (Film film : films) {
            film.setLocation(location);
        }

        return location;
    }

    public ComptePrepaye getComptePrepaye() {
        return comptePrepaye;
    }

    public String resumer() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- ").append(nom).append(" --").append("\n");

        if (listeLocations.stream().anyMatch(l -> !l.estTerminee())) {
            sb.append("Une location est en cours").append("\n");
        } else {
            sb.append("Pas de location en cours").append("\n");
        }

        sb.append("Montant sur le compte prépayé : ").append(comptePrepaye.getSolde()).append("€").append("\n");

        return sb.toString();
    }
}
