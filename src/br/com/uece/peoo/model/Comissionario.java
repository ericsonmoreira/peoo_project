package br.com.uece.peoo.model;

/**
 * os comissionados devem receber o valor total de vendas multiplicado pela percentagem,
 * independentemente do número de horas trabalhadas;
 */
public class Comissionario extends Colaborador {

    private double valorComissao; // porcentagem

    private double valorVendasMes;

    public double getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(double valorComissao) {
        this.valorComissao = valorComissao;
    }

    public double getValorVendasMes() {
        return valorVendasMes;
    }

    public void setValorVendasMes(double valorVendasMes) {
        this.valorVendasMes = valorVendasMes;
    }

    public Comissionario(int numHorasMes, String nome, double valorComissao, double valorVendasMes) {
        super(numHorasMes, nome);
        setValorComissao(valorComissao);
        setValorVendasMes(valorVendasMes);
    }

    @Override
    public double calcularSalario() {
        return valorVendasMes * valorComissao;
    }

    @Override
    public String toString() {
        return "Comissionario{" +
                "valorComissao=" + valorComissao +
                ", valorVendasMes=" + valorVendasMes +
                ", numHorasMes=" + numHorasMes +
                ", nome='" + nome + '\'' +
                '}';
    }
}
