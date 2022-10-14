package fr.notavone.dvdTek;

import fr.notavone.dvdTek.Facture;

public class FactureTest {
    private Facture facture;
    public FactureTest() {
        Film film = new Film("Le seigneur des anneaux", "Peter Jackson", "Fantastique", 2.56);
        Client client = new Client("Leo", "hugonnot");
        facture = new Facture(client, film);
    }
}
