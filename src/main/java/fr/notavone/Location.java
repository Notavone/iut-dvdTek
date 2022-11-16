package fr.notavone;

import fr.notavone.exceptions.SoldeInsuffisantException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Location {
    public static final int UN_JOUR = 1;
    public static final int DEUX_JOURS = 2;
    public static final int TROIS_JOURS = 3;

    public static final int ZERO_DOUZE = 1;
    public static final int DOUZE_VINGTQUATRE = 2;
    public static final int VINGTQUATRE_TRENTESIX = 3;
    public static final int TRENTESIX_QUARANTEHUIT = 4;
    public static final int QUARANTEHUIT_SOIXANTE = 5;

    private final Client client;
    private final Agence agence;
    private final List<Film> films;
    private final Date date;
    private final MoyenPaiement moyenPaiement;
    private final int duree;
    private double montantDejaPaye = 0;
    private boolean terminee = false;

    public Location(Client client, Agence agence, List<Film> films, Date date, int duree, MoyenPaiement moyenPaiement) {
        this.client = client;
        this.agence = agence;
        this.films = films;
        this.date = date;
        this.duree = duree;
        this.moyenPaiement = moyenPaiement;
    }

    public Location(Client client, Agence agence, List<Film> films, int duree, MoyenPaiement moyenPaiement) {
        this(client, agence, films, new Date(), duree, moyenPaiement);
    }

    public Client getClient() {
        return client;
    }

    public Agence getAgence() {
        return agence;
    }

    public List<Film> getFilms() {
        return films;
    }

    public Date getDate() {
        return date;
    }

    public int getDuree() {
        return duree;
    }

    public void retourner(MoyenPaiement moyenPaiement) {
        for (Film film : films) {
            film.setLocation(null);
        }
    }

    public double calculerPrix() {
        double prix = 0;
        if (getFilms() != null) {
            for (Film film : getFilms()) {
                prix += film.getPrixLocation();
            }
        }

        switch (duree) {
            case UN_JOUR -> prix *= 2;
            case DEUX_JOURS -> prix *= 1.7;
            case TROIS_JOURS -> prix *= 1.5;
            default -> prix *= 1;
        }

        return prix;
    }

    public double calculerRemboursement() {
        double remboursement = calculerPrix();
        switch (duree) { //faut changer par rapport a la date de retour mais jsp comment car jsuis noopy
            case ZERO_DOUZE -> remboursement *= 0.833;
            case DOUZE_VINGTQUATRE -> remboursement *= 0.667;
            case VINGTQUATRE_TRENTESIX -> remboursement *= 0.5;
            case TRENTESIX_QUARANTEHUIT -> remboursement *= 0.33;
            case QUARANTEHUIT_SOIXANTE -> remboursement *= 0.167;
            default -> remboursement *= 0;
        }
        return remboursement;
    }

    public String resumer() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("-- Location de l'agence ").append(agence.getNom()).append(" --").append("\n");
        sb.append("Client: ").append(client.getNom()).append("\n");
        sb.append("Durée: ").append(duree).append(" jours à partir du ").append(sdf.format(date)).append("\n");
        sb.append("Films: ").append("\n");

        for (Film film : films) {
            sb.append(" - ").append(film.getTitre()).append("\n");
        }

        return sb.toString();
    }

    public void facturer() throws SoldeInsuffisantException {
        double montant = calculerPrix();
        if (moyenPaiement == MoyenPaiement.COMPTE_PREPAYE) {
            client.getComptePrepaye().debit(montant);
        }

        montantDejaPaye += montant;
    }

    public void retour() {
        double montant = calculerRemboursement();
        client.getComptePrepaye().credit(montant);
        this.terminee = true;
    }

    public boolean estTerminee() {
        return terminee;
    }
}
