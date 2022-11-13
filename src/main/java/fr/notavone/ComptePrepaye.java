package fr.notavone;

import fr.notavone.exceptions.SoldeInsuffisantException;

public class ComptePrepaye {
    private double solde;

    public ComptePrepaye(double solde) {
        this.solde = solde;
    }

    public ComptePrepaye() {
        this(0);
    }

    public double getSolde() {
        return solde;
    }

    public void debit(double montant) throws SoldeInsuffisantException {
        if (montant > solde) {
            throw new SoldeInsuffisantException();
        }

        solde -= montant;
    }

    public void credit(double montant) {
        solde += montant;
    }

}
