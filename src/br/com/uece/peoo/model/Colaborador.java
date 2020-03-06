package br.com.uece.peoo.model;

/**
 * Uma empresa tem três tipos de colaborados: o comissionado, o horista e. assalariado. Todos os colaboradores
 * registram, para efeito de controle, o número de horas trabalhadas no mês. Adicionalmente, os comissionados registram
 * o valor do percentual de comissão e o valor total de vendas acumuladas no mês; os horistas registram o valor
 * recebido por hora, e os assalariados registram o valor do salário.
 * Cada colaborador pertence a um departamento, que possui código e nome. No final de cada mês, cada departamento
 * deverá calcular o salário de seus colaboradores da seguinte forma: os comissionados devem receber o valor total de
 * vendas multiplicado pela percentagem, independentemente do número de horas trabalhadas; os horistas devem receber o
 * valor da hora trabalhada multiplicado pelo número de horas trabalhadas; e os assalariados devem receber o valor
 * nominal do salário. Crie no departamento métodos de adicionar e remover colaborador. Crie um método para gerar folha
 * salarial, que mostre o nome e salário de cada funcionário ao final do mês, o valor total de salários daquele
 * departamento.
 * Crie uma classe Main, representando uma empresa. Crie alguns departamentos e alguns funcionários para cada
 * departamento. Execute a folha salarial dos departamentos do mês. Apresente ao final uma lista com o nome dos
 * departamentos e seu valor de folha salarial, ordenado decrescentemente pelo valor da folha.
 */
public abstract class Colaborador {

    protected int numHorasMes;

    protected String nome;

    public int getNumHorasMes() {
        return numHorasMes;
    }

    public void setNumHorasMes(int numHorasMes) {
        this.numHorasMes = numHorasMes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    protected Colaborador(int numHorasMes, String nome) {
        this.numHorasMes = numHorasMes;
        this.nome = nome;
    }

    public abstract double calcularSalario();

}
