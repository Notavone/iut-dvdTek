package fr.notavone.dvdTek;

import fr.notavone.dvdTek.Client;
import fr.notavone.dvdTek.Film;
import fr.notavone.dvdTek.Location;

import java.util.ArrayList;
import java.util.Date;

public class LocationTest {
    private Location location;
    public LocationTest() {
        location = new Location(new ArrayList<Film>(), new Client("nom", "prenom"), new Date(), new Date());
    }
}
