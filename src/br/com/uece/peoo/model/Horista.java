package br.com.uece.peoo.model;

/**
 * os horistas devem receber o valor da hora trabalhada multiplicado pelo número de horas trabalhadas;
 */
public class Horista extends Colaborador {

    private double valorHora;

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public Horista(int numHorasMes, String nome, double valorHora) {
        super(numHorasMes, nome);
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return valorHora * numHorasMes;
    }

    @Override
    public String toString() {
        return "Horista{" +
                "valorHora=" + valorHora +
                ", numHorasMes=" + numHorasMes +
                ", nome='" + nome + '\'' +
                '}';
    }
}
