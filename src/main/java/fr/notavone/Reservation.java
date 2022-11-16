package fr.notavone;

public record Reservation(Client client, Date dateDebut, Date dateFin, Film film) {
}
