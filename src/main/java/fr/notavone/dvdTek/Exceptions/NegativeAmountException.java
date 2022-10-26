package fr.notavone.dvdTek.Exceptions;

public class NegativeAmountException extends Exception {
    public NegativeAmountException() {
        super("Amount cannot be negative");
    }
}
