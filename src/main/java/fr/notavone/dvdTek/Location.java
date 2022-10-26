package fr.notavone.dvdTek;

import java.util.ArrayList;
import java.util.Date;

public class Location {
    private final ArrayList<Film> films;
    private final Client client;
    private final Date dateLocation;
    private final Date dateRetour;

    private final MoyenDePaiement moyenDePaiement;

    public Location(ArrayList<Film> films, Client client, Date dateLocation, Date dateRetour, MoyenDePaiement moyenDePaiement) {
        this.films = films;
        this.client = client;
        this.dateLocation = dateLocation;
        this.dateRetour = dateRetour;
        this.moyenDePaiement = moyenDePaiement;
    }
    public Location(ArrayList<Film> films, Client client, Date dateLocation, Date dateRetour) {
        this(films, client, dateLocation, dateRetour, MoyenDePaiement.CB);
    }

    public void renouveler(int nbJours) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public Client getClient() {
        return client;
    }

    public Date getDateLocation() {
        return dateLocation;
    }

    public Date getDateRetour() {
        return dateRetour;
    }
}
