package model;

import org.json.simple.JSONObject;
import util.Question;

/**
 * Classe para Conta Poupanca.
 */
public class ContaCorrente extends Conta {

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
        this.saldo -= 50;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        return "[NumConta: " + this.numConta + ";"
                + " Titular: " + this.titular + ";"
                + " Saldo: " + Question.numberFormat.format(this.saldo) + ";"
                + " Limite: " + Question.numberFormat.format(this.limite) +"]";
    }

    @Override
    public JSONObject toJSONObject() {
        var aux = super.toJSONObject();
        aux.put("limite", this.limite);
        return aux;
    }

}
