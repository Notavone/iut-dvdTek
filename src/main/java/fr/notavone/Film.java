package fr.notavone;

public class Film {
    /* SUPPORTS */
    public static final int SUPPORT_DVD = 1;
    public static final int SUPPORT_BLUE_RAY = 2;
    public static final int SUPPORT_K7 = 3;

    /* CATÉGORIES */
    public static final int CATEGORIE_NOUVEAU = 1;
    public static final int CATEGORIE_RECENT = 2;
    public static final int CATEGORIE_DE_L_ANNEE = 3;
    public static final int CATEGORIE_DE_L_AN_PASSE = 4;
    public static final int CATEGORIE_VIEUX = 5;

    /* GENRES */
    public static final int GENRE_ACTION = 1;
    public static final int GENRE_ADVENTURE = 2;
    public static final int GENRE_ANIME = 3;
    public static final int GENRE_COMEDY = 4;
    public static final int GENRE_DRAMA = 5;


    private final String titre;
    private final int support;
    private int categorie;

    private int genre;
    private double prixLocation;
    private Location location;

    public Film(String titre, int support, int categorie, int genre, double prixLocation) {
        this.titre = titre;
        this.support = support;
        this.categorie = categorie;
        this.genre = genre;
        this.prixLocation = prixLocation;
    }

    public Film(String titre, int support, double prixLocation) {
        this(titre, support, CATEGORIE_NOUVEAU, GENRE_ACTION, prixLocation);
    }

    public String getTitre() {
        return titre;
    }

    public int getSupport() {
        return support;
    }

    public int getCategorie() {
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

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public double getPrixLocation() {
        double multiplicateur = 1;

        switch(categorie) {
            case CATEGORIE_NOUVEAU -> multiplicateur += 1;
            case CATEGORIE_RECENT -> multiplicateur += 0.5;
            case CATEGORIE_DE_L_ANNEE -> multiplicateur += 0.25;
            case CATEGORIE_DE_L_AN_PASSE -> multiplicateur += .1;
            case CATEGORIE_VIEUX -> multiplicateur += 0;
        }

        switch (support) {
            case SUPPORT_BLUE_RAY -> multiplicateur += 1;
            case SUPPORT_K7 -> multiplicateur += .75;
            case SUPPORT_DVD -> multiplicateur += 0.5;
        }

        return prixLocation * multiplicateur;
    }
}
