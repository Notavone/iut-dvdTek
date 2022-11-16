package fr.notavone;

import fr.notavone.exceptions.SoldeInsuffisantException;

import java.text.DecimalFormat;
import java.util.List;

public class Location {
    public static final int UN_JOUR = 1;
    public static final int DEUX_JOURS = 2;
    public static final int TROIS_JOURS = 3;

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

    public void retourner() {
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

        return prix * duree;
    }

    public double calculerRemboursement() {
        Date date = new Date();
        float diff = new Date(duree, this.date).hourDifference(date);
        double d = (calculerPrix() / (duree * 2)) * ((diff / 12) - 1);
        return (double) Math.round(d * 100) / 100;
    }

    public String resumer() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- Location de l'agence ").append(agence.getNom()).append(" --").append("\n");
        sb.append("Client: ").append(client.getNom()).append("\n");
        sb.append("Durée: ").append(duree).append(" jours à partir du ").append(date.toString()).append("\n");
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

    public void retour(MoyenPaiement moyenPaiement) {
        if (terminee) return;
        Date dateFin = new Date(duree, date);
        Date now = new Date();
        // si rendu avant la fin
        if (moyenPaiement == MoyenPaiement.COMPTE_PREPAYE && now.isBefore(dateFin)) {
            double montant = calculerRemboursement();
            System.out.println("Remboursement de : " + montant + "€");
            client.getComptePrepaye().credit(montant);
        }
        // rendu en retard
        if (now.isAfter(dateFin)) {
            double montant = Math.abs(now.hourDifference(dateFin));
            try {
                client.getComptePrepaye().debit(montant);
            } catch (SoldeInsuffisantException e) {
                System.err.println("Le client ne peut pas payer sa facture de " + montant + "€");
            }
        }
        terminee = true;
        retourner();
    }

    public boolean estTerminee() {
        return terminee;
    }
}
