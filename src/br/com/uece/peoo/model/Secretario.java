package br.com.uece.peoo.model;

/**
 * Secretários trabalham 20, 30 ou 40 horas semanais. Seu salário é a calculado pelo valor da
 * hora de trabalho, que é de R$8 para quem trabalha até 30h/semana e R$10 para quem
 * trabalha 40h/semana, vezes a quantidade de horas mensais trabalhadas (considere um mês
 * como tendo 4 semanas).
 */
public class Secretario extends Funcionario {

    private CARGA_HORARIA cargaHoraria; // carga horária do funcionário.

    public CARGA_HORARIA getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(CARGA_HORARIA cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * Construtor do secretário.
     *
     * @param matricula matrícula do secretário.
     * @param nome nome do secretário.
     * @param cargaHoraria carga horária do secretário.
     */
    public Secretario(int matricula, String nome, CARGA_HORARIA cargaHoraria) {
        super(matricula, nome);
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * Calculado pelo valor da hora de trabalho, que é de R$8 para quem trabalha até 30h/semana e R$10 para quem
     * trabalha 40h/semana, vezes a quantidade de horas mensais trabalhadas (considere um mês como tendo 4 semanas).
     *
     * @return salário do secretário.
     */
    public double calcularSalario() {
        return 4 * ((cargaHoraria == CARGA_HORARIA.QUARENTA_HORAS_SEMANAIS)? 10: 8) * cargaHoraria.getValor();
    }

    @Override
    public String toString() {
        return "Secretario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
