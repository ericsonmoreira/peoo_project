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

    /**
     * Construtor Padão.
     *
     * @param numConta número da conta.
     * @param titular nome do titular da conta.
     * @param saldo saldo inicial da conta.
     * @param limite limite da conta.
     */
    public ContaCorrente(int numConta, String titular, double saldo, double limite) {
        super(numConta, titular, saldo);
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
        return "ContaCorrente{" +
                "numConta=" + numConta +
                ", titular='" + titular + '\'' +
                ", saldo=" + Question.numberFormat.format(this.saldo) +
                ", limite='" + limite + '\'' +
                "}";
    }

    @Override
    public JSONObject toJSONObject() {
        var aux = super.toJSONObject();
        aux.put("limite", this.limite);
        return aux;
    }

}
