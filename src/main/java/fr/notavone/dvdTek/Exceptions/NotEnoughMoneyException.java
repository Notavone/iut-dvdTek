package fr.notavone.dvdTek.Exceptions;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super("You don't have enough money");
    }
}
