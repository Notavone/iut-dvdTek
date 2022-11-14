package fr.notavone;

public class Film {
    /* SUPPORTS */
    public static final int SUPPORT_DVD = 1;
    public static final int SUPPORT_BLUE_RAY = 2;

    /* CATÉGORIES */
    public static final int CATEGORIE_NOUVEAU = 1;
    public static final int CATEGORIE_RECENT = 2;
    public static final int CATEGORIE_DE_L_ANNEE = 3;
    public static final int CATEGORIE_VIEUX = 4;

    private final String titre;
    private final int support;
    private int categorie;
    private double prixLocation;
    private Location location;

    public Film(String titre, int support, int categorie, double prixLocation) {
        this.titre = titre;
        this.support = support;
        this.categorie = categorie;
        this.prixLocation = prixLocation;
    }

    public Film(String titre, int support, double prixLocation) {
        this(titre, support, CATEGORIE_NOUVEAU, prixLocation);
    }

    public String getTitre() {
        return titre;
    }

    public int getSupport() {
        return support;
    }

    public double getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getPrixLocation() {
        double multiplicateur = 1;

        switch(categorie) {
            case CATEGORIE_NOUVEAU -> multiplicateur += 1;
            case CATEGORIE_RECENT -> multiplicateur += 0.5;
            case CATEGORIE_DE_L_ANNEE -> multiplicateur += 0.25;
            case CATEGORIE_VIEUX -> multiplicateur += 0;
        }

        switch (support) {
            case SUPPORT_DVD -> multiplicateur += 0.5;
            case SUPPORT_BLUE_RAY -> multiplicateur += 1;
        }

        return prixLocation * multiplicateur;
    }
}
