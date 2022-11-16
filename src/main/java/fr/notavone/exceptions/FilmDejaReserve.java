package fr.notavone.exceptions;

public class FilmDejaReserve extends Exception {
    public FilmDejaReserve() {
        super("Le film est déjà réservé par un autre client à cette dates");
    }
}
