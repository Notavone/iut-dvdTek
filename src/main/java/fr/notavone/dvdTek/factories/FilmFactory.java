package fr.notavone.dvdTek.factories;

import fr.notavone.dvdTek.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmFactory {
    public static List<Film> getFilms() {
        List<Film> films = new ArrayList<Film>();

        films.add(new Film("Le seigneur des anneaux", "Peter Jackson", "Fantastique", 2.56));
        films.add(new Film("Matrix", "Les Wachowski", "Science-fiction", 2.56));
        films.add(new Film("Le parrain", "Francis Ford Coppola", "Policier", 2.56));
        films.add(new Film("Kung Fu Panda", "Mark Osborne", "Animation", 2.56));
        films.add(new Film("La guerre des étoiles", "George Lucas", "Science-fiction", 2.56));
        films.add(new Film("Le roi lion", "Roger Allers", "Animation", 2.56));
        films.add(new Film("Le loup de Wall Street", "Martin Scorsese", "Comédie", 2.56));
        films.add(new Film("La planète des singes", "Franklin J. Schaffner", "Science-fiction", 2.56));
        films.add(new Film("La ligne verte", "Frank Darabont", "Policier", 2.56));
        films.add(new Film("Fast and Furious", "Rob Cohen", "Action", 2.56));
        films.add(new Film("La cité de la peur", "Alain Berbérian", "Comédie", 2.56));
        films.add(new Film("Hotel Transylvanie", "Genndy Tartakovsky", "Animation", 2.56));
        films.add(new Film("Les dents de la mer", "Steven Spielberg", "Horreur", 2.56));
        films.add(new Film("Les visiteurs", "Jean-Marie Poiré", "Comédie", 2.56));
        films.add(new Film("Dikkenek", "Dany Boon", "Comédie", 2.56));
        films.add(new Film("Tintin au Tibet", "Steven Spielberg", "Animation", 2.56));

        return films;
    }
}
