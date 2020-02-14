package model;

import java.text.NumberFormat;

/**
 * Uma universidade possui um registro de seus funcionários armazenando a matrícula e nome de cada um. Por padrão,
 * o salário de todos funcionários é o valor do salário mínimo (considere o valor de R$1000 para facilitar). Na
 * universidade trabalham professores, secretários e servidores. Funcionários tem os métodos
 * imprimirDados() e calcularSalario().
 *
 */
public class Funcionario {

    // Enum interno para evitar iFs dentro do código.
    public static enum CARGA_HORARIA {
        VINTE_HORAS_SEMANAIS(20.0),
        TRINTA_HORAS_SEMANAIS(30.0),
        QUARENTA_HORAS_SEMANAIS(40.0);

        private double valor;

        CARGA_HORARIA(double valor) {
            this.valor = valor;
        }

        public double getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return valor + "H";
        }
    }

    public static final double SM =  1000.00; // Constante para salvar o valor de um SALÁRIO MÍNIMO.

    protected int matricula; // matricula do funcionário.

    protected String nome; // nome do funcionário

    /**
     * Construtor de um {@link Funcionario}.
     *
     * @param matricula matricula do funcionário.
     * @param nome nome do funcionário.
     */
    public Funcionario(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Imprime os dados do funcionário.
     */
    public void imprimirDados() {
        System.out.println(toString());
    }

    /**
     * Calcula o salário do funcionário.
     *
     * @return por default é um salário mínimo (nesse caso é R$ 1.000,00).
     */
    public double calcularSalario() {
        return  SM;
    }

    @Override
    public String toString() {
        var nf = NumberFormat.getCurrencyInstance();
        return "Funcionario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                '}';
    }
}
