package fr.notavone.dvdTek;

import java.util.ArrayList;
import java.util.Collection;

public class Facture {
    private Location location;
    private double montant;
    private Client client;
    private ArrayList<Film> filmsChoisis;

    public Facture(Client client, ArrayList<Film> filmsChoisis){
        this.client = client;
        this.filmsChoisis = filmsChoisis;
    }

    public Facture(Client client, Film filmChoisi){
        this.client = client;
        this.filmsChoisis = new ArrayList<>();
        filmsChoisis.add(filmChoisi);
    }

    public double getMontant() {
        return montant;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Film> getFilmsChoisis() {
        return filmsChoisis;
    }



}
