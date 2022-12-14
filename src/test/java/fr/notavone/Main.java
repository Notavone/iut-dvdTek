package fr.notavone;

import fr.notavone.exceptions.FilmDejaReserve;
import fr.notavone.exceptions.FilmIndisponibleException;
import fr.notavone.exceptions.SoldeInsuffisantException;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        Film film1 = new Film("Film 1", Film.SUPPORT_BLUE_RAY, 1);
        Film film2 = new Film("Film 2", Film.SUPPORT_DVD, 2);
        Film film3 = new Film("Film 3", Film.SUPPORT_DVD, 3);
        Film film4 = new Film("Film 4", Film.SUPPORT_BLUE_RAY, 4);
        Film film5 = new Film("Film 5", Film.SUPPORT_BLUE_RAY, 5);

        Client roberto = new Client("Roberto");
        Client toto = new Client("toto");

        Location location1 = null;

        System.out.println(roberto.resumer());

        System.out.println("Ajout de solde sur le compte prépayé du client");
        roberto.getComptePrepaye().credit(100);

        System.out.println(roberto.resumer());

        Agence agence = new Agence("Agence 1");
        agence.ajouterFilm(film1, film2, film3, film4, film5);

        try {
            List<Film> films1 = List.of(film1, film2, film3);
            System.out.println("On va louer " + films1.size() + " films avec le compte prépayé");

            location1 = roberto.louerFilms(agence, films1, Location.TROIS_JOURS, MoyenPaiement.COMPTE_PREPAYE);
            System.out.println(location1.resumer());

            System.out.println("On vérifie que le compte est bien débité de " + location1.calculerPrix() + "€");
            System.out.println(roberto.resumer());
            System.out.println(roberto.statisiques());

        } catch (FilmIndisponibleException | SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }

        /* RÉSERVATION */
        try {
            System.out.println("Toto réserve film5 aujourd'hui pour 3 jours");
            toto.reserver(film5, new Date(), Location.TROIS_JOURS);
        } catch (FilmDejaReserve e) {
            System.out.println(e.getMessage());
        }

        // déjà réservé
        try {
            System.out.println("Roberto veut louer film5.");
            roberto.louerFilms(agence, List.of(film5), Location.UN_JOUR, MoyenPaiement.COMPTE_PREPAYE);
        } catch (SoldeInsuffisantException | FilmIndisponibleException e) {
            System.out.println(e.getMessage());
            System.out.println("Mais il est réservé par toto !");
        }

        assert location1 != null;
        System.out.println("Roberto rend sa location");
        roberto.retour(location1, MoyenPaiement.COMPTE_PREPAYE);
        System.out.println("Roberto possède maintenant " + roberto.getComptePrepaye().getSolde() + "€");
    }
}