package fr.notavone.dvdTek;


public class Statistiques {

    private final Client client;

    public Statistiques(Client client) {
        this.client = client;
    }

    public String getStastiques() {
        int nbDvd = 0;
        int nbBlueRay = 0;
        int nbk7 = 0;

        int nbAction = 0;
        int nbComedie = 0;
        int nbHorreur = 0;
        int nbAventure = 0;

        for(Location location : client.getLocations()){
            for(Film film : location.getFilms()){

                switch (film.getSupport()) {
                    case K7 -> nbk7++;
                    case DVD -> nbDvd++;
                    case BlueRay -> nbBlueRay++;
                }

                switch (film.getGenre()) {
                    case ACTION -> nbAction++;
                    case COMEDIE -> nbComedie++;
                    case HORREUR -> nbHorreur++;
                    case AVENTURE -> nbAventure++;
                }

            }
        }
        return "";
    }
}
