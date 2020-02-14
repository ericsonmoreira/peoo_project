package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Essa universidade possui um nome e uma lista de funcionários. Crie um método para adicionar
 * funcionários na lista e outro para gerar a folha de pagamento desta universidade, mostrando
 * os dados e salário final de todos os funcionários, além do valor total pago pela universidade.
 */
public class Universidade {

    private String nome; // nome da universidade.

    private List<Funcionario> funcionarios; // funcionarios da universidade.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Universidade(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<Funcionario>();
    }

    /**
     * Adiciona um funcionário. Pode ser um professor(a), secretário(a) ou técnico(a).
     *
     * @param funcionario um funcionário.
     */
    public  void addFuncionario(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }

    /**
     * A folha de pagamento desta universidade mostra:
     *      1) os dados dos funcioários juntamente com salário final de todos os funcionários,
     *      2) além do valor total pago pela universidade.
     */
    public  void showFolhaPagamento(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("------------------------ Folha de Pagamentos ------------------------");
        funcionarios.forEach(funcionario -> System.out.println(funcionario + ", salário: " + nf.format(funcionario.calcularSalario())));
        System.out.println("Total pago pela Universidade " + nome +": " +
                nf.format(funcionarios.stream().mapToDouble(Funcionario::calcularSalario).sum()));
        System.out.println("---------------------------------------------------------------------");
    }
}
