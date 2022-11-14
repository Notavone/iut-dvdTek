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

    public String statisiques() {
        int[] supports = {0, 0, 0};
        int[] categories = {0, 0, 0, 0, 0};
        int[] genres = {0, 0, 0, 0, 0};

        for (Location l : listeLocations) {
            for (Film f : l.getFilms()) {
                supports[f.getSupport() - 1]++;
                categories[f.getCategorie() - 1]++;
                genres[f.getGenre() - 1]++;
            }
        }
        int bestSupport = 0;
        int bestCategory = 0;
        int bestGenre = 0;
        for (int i = 0; i < supports.length; i++) {if (supports[i] > supports[bestSupport]) bestSupport = i;}
        for (int i = 0; i < categories.length; i++) {if (categories[i] > categories[bestCategory]) bestCategory = i;}
        for (int i = 0; i < genres.length; i++) {if (genres[i] > genres[bestGenre]) bestGenre = i;}

        String strSupport;
        String strCategory;
        String strGenre;
        switch (bestSupport + 1) {
            case 1 -> strSupport = "DVD";
            case 2 -> strSupport = "Blue Ray";
            case 3 -> strSupport = "K7";
            default -> strSupport = "Inconnu";
        }

        switch (bestCategory + 1) {
            case 1 -> strCategory = "Nouveau";
            case 2 -> strCategory = "Récent";
            case 3 -> strCategory = "De cette année";
            case 4 -> strCategory = "De l'année passée";
            case 5 -> strCategory = "Ancien";
            default -> strCategory = "Inconnue";
        }

        switch (bestGenre + 1) {
            case 1 -> strGenre = "Action";
            case 2 -> strGenre = "Aventure";
            case 3 -> strGenre = "Animé";
            case 4 -> strGenre = "Comédie";
            case 5 -> strGenre = "Drame";
            default -> strGenre = "Inconnu";
        }

        return "Support préféré : " + strSupport + "\n" +
                "Catégorie préférée : " + strCategory + "\n" +
                "Genre préféré : " + strGenre + "\n";
    }
}
