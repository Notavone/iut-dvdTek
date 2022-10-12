import java.util.ArrayList;
import java.util.List;

public class Client {
    private final ArrayList<Location> locations;
    private final String nom;
    private final String prenom;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.locations = new ArrayList<Location>();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Film> observer(Rayon rayon) {
        throw new UnsupportedOperationException("Not supported yet.");
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

}
