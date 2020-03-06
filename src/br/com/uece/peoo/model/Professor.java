package br.com.uece.peoo.model;

import java.text.NumberFormat;

/**
 * O salário dos professores depende da titulação e da sua carga horária. Para os mestres, o valor da hora/aula é R$80,
 * enquanto o doutor ganha R$100 por hora/aula. Além disso, caso o professor seja coordenador, ele pode tem uma
 * gratificação de 20% do valor final de seu salário (considere um mês como tendo 4 semanas).
 */
public class Professor extends Funcionario{

    // Enum interno para evitar iFs dentro do código.
    public static enum TITULARIDADE {
        MESTRE(80.0),
        DOUTOR(100.0);

        private final double valorHoraAula;

        public double getValorHoraAula() {
            return valorHoraAula;
        }

        TITULARIDADE(double valorHoraAula) {
            this.valorHoraAula = valorHoraAula;
        }

        @Override
        public String toString() {
            return this.name();
        }
    }

    private TITULARIDADE titularidade; // um professor pode ter Mestrado ou Doutorado.

    private CARGA_HORARIA cargaHoraria; // carga horária do professor.

    private boolean isCoordenador; // o professor é um coordenador?

    public TITULARIDADE getTitularidade() {
        return titularidade;
    }

    public void setTitularidade(TITULARIDADE titularidade) {
        this.titularidade = titularidade;
    }

    public CARGA_HORARIA getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(CARGA_HORARIA cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean isCoordenador() {
        return isCoordenador;
    }

    public void setCoordenador(boolean coordenador) {
        isCoordenador = coordenador;
    }

    /**
     * Construtor de um Professor.
     *  @param matricula matrícula do professor.
     * @param nome nome do professor.
     * @param titularidade titularidade do professor (mestre ou doutor).
     * @param cargaHoraria carga horrário do professor (20, 30 ou 40 horas semanais).
     */
    public Professor(int matricula, String nome, TITULARIDADE titularidade, CARGA_HORARIA cargaHoraria, boolean isCoordenador) {
        super(matricula, nome);
        this.titularidade = titularidade;
        this.isCoordenador = isCoordenador;
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * O salário dos professores depende da titulação e da sua carga horária. Para os mestres, o valor da hora/aula
     * é R$80, enquanto o doutor ganha R$100 por hora/aula. Além disso, caso o professor seja coordenador, ele pode
     * tem uma gratificação de 20% do valor final de seu salário (considere um mês como tendo 4 semanas).
     *
     * @return Salário de em professor.
     */
    @Override
    public double calcularSalario() {
        return 4.0 * titularidade.getValorHoraAula() * cargaHoraria.getValor() * ((isCoordenador()? 1.2: 1.0));
    }

    @Override
    public String toString() {
        var nf = NumberFormat.getCurrencyInstance();
        return "Professor{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", titularidade=" + titularidade.toString() +
                ", cargaHoraria=" + cargaHoraria.toString() +
                ", isCoordenador=" + isCoordenador +
                '}';
    }
}
