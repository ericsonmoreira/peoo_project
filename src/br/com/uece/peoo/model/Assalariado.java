package br.com.uece.peoo.model;

/**
 * Os assalariados devem receber o valor nominal do salário.
 */
public class Assalariado extends Colaborador {

    private double valorSalario;

    public double getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(double valorSalario) {
        this.valorSalario = valorSalario;
    }

    public Assalariado(int numHorasMes, String nome, double valorSalario) {
        super(numHorasMes, nome);
        this.valorSalario = valorSalario;
    }

    @Override
    public double calcularSalario() {
        return valorSalario;
    }

    @Override
    public String toString() {
        return "Assalariado{" +
                "valorSalario=" + valorSalario +
                ", numHorasMes=" + numHorasMes +
                ", nome='" + nome + '\'' +
                '}';
    }
}
