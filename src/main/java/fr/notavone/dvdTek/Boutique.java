package fr.notavone.dvdTek;

import java.util.ArrayList;
import java.util.List;

public class Boutique {
    private final List<Client> clients;
    private final List<Rayon> rayons;

    public Boutique() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public Boutique(List<Rayon> rayons) {
        this(rayons, new ArrayList<>());
    }

    public Boutique(List<Rayon> rayons, List<Client> clients) {
        this.rayons = rayons;
        this.clients = clients;
    }

    public List<Rayon> getRayons() {
        return rayons;
    }

    public boolean verifierDisponibilite(Film film) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Film> verifierDisponibilite(List<Film> films) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Client> getClients() {
        return clients;
    }
}
