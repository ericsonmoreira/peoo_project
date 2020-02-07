package model;

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

    public ContaPoupanca(int numAccount, String holder, double balance, double taxaRendimento) {
        super(numAccount, holder, balance);
        this.taxaRendimento = taxaRendimento;
    }

    /**
     * Faz render o dinheiro que tem na conta.
     */
    public void render(){
        saldo += saldo * taxaRendimento;
    }
}
