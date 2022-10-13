package fr.notavone.dvdTek;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {

    @Test
    public void unClientEntreDansLaBoutique() {
        Client client = new Client("Jean", "Dupont");

        Rayon rayon = Mockito.mock(Rayon.class);
        ArrayList<Rayon> rayons = new ArrayList<>();
        rayons.add(rayon);

        Boutique boutique = new Boutique(rayons);

        List<Rayon> rayonList = client.visiter(boutique);

        Assert.assertEquals(rayonList.size(), 1);
        Assert.assertEquals(rayonList.get(0), rayon);
        Assert.assertEquals(rayonList, rayons);
    }

    @Test
    public void unClientObserveUnRayon() {
        Client client = new Client("Jean", "Dupont");

        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film("f1", "f1", "f1", 1.1));
        films.add(new Film("f2", "f2", "f2", 1.1));

        ArrayList<Rayon> rayons = new ArrayList<>();
        rayons.add(new Rayon(films));
        Boutique boutique = new Boutique(rayons);
        client.visiter(boutique);
        ArrayList<Film> filmsDeLaBoutique = (ArrayList<Film>) client.observer(boutique.getRayons().get(0)); //boutique.getRayons().get(0).getFilms();
        Assert.assertNotNull(filmsDeLaBoutique);
        Assert.assertEquals(filmsDeLaBoutique.size(), films.size());
    }

    @Test
    public void unClientChoisisUnLivre() {
        Client client = new Client("Jean", "Dupont");

        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film("f1", "f1", "f1", 1.1));
        films.add(new Film("f2", "f2", "f2", 1.1));

        ArrayList<Rayon> rayons = new ArrayList<>();
        rayons.add(new Rayon(films));
        Boutique boutique = new Boutique(rayons);
        client.visiter(boutique);
        ArrayList<Film> filmsDeLaBoutique = (ArrayList<Film>) client.observer(boutique.getRayons().get(0)); //boutique.getRayons().get(0).getFilms();
        client.choisis(filmsDeLaBoutique.get(0));
        Assert.assertEquals(client.getFilmsChoisis().size(), 1);
        Assert.assertEquals(client.getFilmsChoisis().get(0), filmsDeLaBoutique.get(0));
    }

    @Test
    public void unClientChoisisDesLivres() {
        Client client = new Client("Jean", "Dupont");

        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film("f1", "f1", "f1", 1.1));
        films.add(new Film("f2", "f2", "f2", 1.1));
        films.add(new Film("f2", "f2", "f3", 1.1));

        ArrayList<Rayon> rayons = new ArrayList<>();
        rayons.add(new Rayon(films));
        Boutique boutique = new Boutique(rayons);
        client.visiter(boutique);
        ArrayList<Film> filmsDeLaBoutique = (ArrayList<Film>) client.observer(boutique.getRayons().get(0)); //boutique.getRayons().get(0).getFilms();
        client.choisis(filmsDeLaBoutique);
        Assert.assertEquals(client.getFilmsChoisis().size(), filmsDeLaBoutique.size());
        Assert.assertArrayEquals(client.getFilmsChoisis().toArray(), filmsDeLaBoutique.toArray());
    }


}
