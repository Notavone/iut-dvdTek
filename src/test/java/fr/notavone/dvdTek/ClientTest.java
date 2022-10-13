package fr.notavone.dvdTek;

import org.junit.Assert;
import org.junit.Test;
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
}
