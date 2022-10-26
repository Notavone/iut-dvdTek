package fr.notavone.dvdTek;

import fr.notavone.dvdTek.supports.Support;

public class Film {
    private static final double NOUVEAU = 1.5;
    private static final double RECENT = 1.2;
    private static final double DE_L_ANNEE = 1.1;
    private static final double DE_L_ANNEE_PASSEE = 1;
    private static final double PLUS_ANCIEN = 0.9;

    private final String titre;
    private final String realisateur;
    private final String genre;
    private final double msrp;
    private double categoriePrixMultiplicateur;
    private boolean disponible;
    private final Support support;

    public Film(String titre, String realisateur, String genre, double msrp, double categoriePrixMultiplicateur, boolean disponible, Support support) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.genre = genre;
        this.msrp = msrp;
        this.categoriePrixMultiplicateur = DE_L_ANNEE_PASSEE;
        this.disponible = disponible;
        this.support = support;
    }

    public Film(String titre, String realisateur, String genre, double msrp, double categoriePrixMultiplicateur, Support support) {
        this(titre, realisateur, genre, msrp, categoriePrixMultiplicateur, true, support);
    }

    public Film(String titre, String realisateur, String genre, double msrp, Support support) {
        this(titre, realisateur, genre, msrp, NOUVEAU, support);
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public String getGenre() {
        return genre;
    }

    public double getMsrp() {
        return msrp;
    }

    public double getCategoriePrixMultiplicateur() {
        return categoriePrixMultiplicateur;
    }

    public void setCategoriePrixMultiplicateur(double categoriePrixMultiplicateur) {
        this.categoriePrixMultiplicateur = categoriePrixMultiplicateur;
    }

    public double getPrixLocation(int nbJours) {
        return msrp * categoriePrixMultiplicateur * (1 + Math.log10(nbJours));
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
