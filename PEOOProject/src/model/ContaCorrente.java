package model;

/**
 * Classe para Conta Poupanca.
 */
public class ContaCorrente extends BankAccount {

    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ContaCorrente(int numAccount, String holder, double balance, double limite) {
        super(numAccount, holder, balance);
        this.limite = limite;
    }

    /**
     * Debita 50 reais do saldo
     */

    public void debitarAnuidade() {
        this.balance -= 50;
    }

}
