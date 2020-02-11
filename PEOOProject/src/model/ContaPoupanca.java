package model;

import org.json.simple.JSONObject;
import util.Question;

/**
 * Classe para conta corrente.
 */
public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(int numConta, String titular, double balance, double taxaRendimento) {
        super(numConta, titular, balance);
        this.taxaRendimento = taxaRendimento;
    }

    /**
     * Faz render o dinheiro que tem na conta.
     */
    public void render(){
        saldo += saldo * taxaRendimento;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", titular='" + titular + '\'' +
                ", saldo=" + Question.numberFormat.format(this.saldo) +
                ", taxaRendimento='" + taxaRendimento + '\'' +
                "}";
    }

    @Override
    public JSONObject toJSONObject() {
        var aux = super.toJSONObject();
        aux.put("taxaRendimento", this.taxaRendimento);
        return aux;
    }
}
