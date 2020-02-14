package model;

/**
 * Técnicos podem trabalhar horas extras, cujo valor unitário é de R$15. Seu salário final é a soma
 * do salário de um funcionário mais o total ganho com horas extras.
 */
public class Tecnico extends Funcionario {

    private final double V_HE = 15.0; // Valor de uma hora extra.

    private int quantHorasExtras; // quantidade de horas extras trabalhadas por um Técnico.

    public int getQuantHorasExtras() {
        return quantHorasExtras;
    }

    public void setQuantHorasExtras(int quantHorasExtras) {
        this.quantHorasExtras = quantHorasExtras;
    }

    /**
     * Construtor de um Técnico.
     *
     * @param matricula matricula do técnico.
     * @param nome nome do técnico.
     * @param quantHorasExtras quantidade de horas extras do técnico.
     */
    public Tecnico(int matricula, String nome, int quantHorasExtras) {
        super(matricula, nome);
        this.quantHorasExtras = quantHorasExtras;
    }

    /**
     * Seu salário final é a soma do salário de um funcionário mais o total ganho com horas extras.
     * @return
     */
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + V_HE * quantHorasExtras;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", quantHorasExtras='" + quantHorasExtras + '\'' +
                '}';
    }
}
