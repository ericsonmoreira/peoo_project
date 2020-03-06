package br.com.uece.peoo.model;

import br.com.uece.peoo.util.Question;

import java.util.ArrayList;

public class Departamento {

    private int cod;

    private String nome;

    private ArrayList<Colaborador> colaboradores;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Departamento(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
        this.colaboradores = new ArrayList<Colaborador>();
    }

    public void addColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }

    public void removerColaborador(Colaborador colaborador) {
        colaboradores.remove(colaborador);
    }

    /**
     * @return Somatoria de todos os salarios dos colaboradores no mês.
     */
    public double valorTotalSalarios() {
        return colaboradores.stream().mapToDouble(Colaborador::calcularSalario).sum();
    }

    /**
     * Mostra o nome e salário de cada funcionário ao final do mês, o valor total de salários daquele departamento.
     */
    public void gerarFolhaSalarial() {
        colaboradores.forEach(colaborador ->
                System.out.println(
                        colaborador +
                        " Salário: " +  Question.numberFormat.format(colaborador.calcularSalario()) +
                        "."
                )
        );
        System.out.println(this + " Toral Salários: " + Question.numberFormat.format(this.valorTotalSalarios()));
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                '}';
    }
}
