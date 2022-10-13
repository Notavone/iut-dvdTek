package fr.notavone.dvdTek;

import fr.notavone.dvdTek.factories.FilmFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        Client jacob = new Client("Jacob", "Masterclass");
        Client philippe = new Client("Philippe", "Larue");
        Client claire = new Client("Claire", "Temple");
        Client danny = new Client("Danny", "Rand");
        Client arthur = new Client("Arthur", "Fleck");

        List<Film> films = FilmFactory.getFilms();
    }
}
