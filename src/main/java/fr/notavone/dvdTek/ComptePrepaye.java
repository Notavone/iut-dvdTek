package fr.notavone.dvdTek;

import fr.notavone.dvdTek.Exceptions.NegativeAmountException;
import fr.notavone.dvdTek.Exceptions.NotEnoughMoneyException;

public class ComptePrepaye {
    private double montant;

    public ComptePrepaye() {
        this.montant = 0;
    }

    public void addMoney(double money) throws NegativeAmountException {
        if (money <= 0) throw new NegativeAmountException();
        montant += money;
    }

    public void paye(double amount) throws NotEnoughMoneyException {
        if (amount > montant) throw new NotEnoughMoneyException();
        montant -= amount;
    }

    public void paye(Facture facture) throws NotEnoughMoneyException {
        paye(facture.getMontant());
    }

    public double getMontant() {
        return montant;
    }
}
