package fr.notavone.dvdTek;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {

    private final Date dateDeDepart;
    private final Date dateDeFin;

    private final ArrayList<Film> films;

    public Reservation(Date dateDeDepart, Date dateDeFin, ArrayList<Film> films) {
        this.dateDeDepart = dateDeDepart;
        this.dateDeFin = dateDeFin;
        this.films = films;
    }

    public Date getDateDeDepart() { return dateDeDepart;}

    public Date getDateDeFin() {
        return dateDeFin;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

}
