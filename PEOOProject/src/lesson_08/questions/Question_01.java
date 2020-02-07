package lesson_08.questions;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.ArrayList;

/**
 * 1. Alterar a classe Conta para ter seus atributos protegido.
 * Criar a subclasse ContaCorrente, com atributo limite e método debitarAnuidade, que debita 50 reais do saldo.
 * Criar a subclasse ContaPoupança, com atributo taxaRendimento e método render, que incrementa o saldo em taxaRendimento%
 * Criar objetos das subclasses na classe Main e usar seus métodos
 */
public class Question_01 {

    public static ArrayList<String> meses = new ArrayList<>();

    static {
        meses.add("Janeiro");
        meses.add("Fevereiro");
        meses.add("Março");
        meses.add("Abrio");
        meses.add("Maio");
        meses.add("Junho");
        meses.add("Julho");
        meses.add("Agosto");
        meses.add("Setembro");
        meses.add("Outubro");
        meses.add("Novembro");
        meses.add("Dezembro");
    }

    public static void main(String[] args) {

        // Criando conta corrente.
        ContaCorrente contaCorrente = new ContaCorrente(1, "Ericson Rogerio Moreira", 1000, 100);

        // Criando conta poupança.
        ContaPoupanca contaPoupanca = new ContaPoupanca(2, "Marilia Gabriela", 1000, 0.05);

        System.out.println("Ano Passado:");
        System.out.println("Conta Corrente: " + contaCorrente);
        System.out.println("Conta Poupança: " + contaPoupanca);

        for (String mes: meses) {
            contaCorrente.debitarAnuidade();
            contaPoupanca.render();
            System.out.println(mes);
            System.out.println("Conta Corrente:" + contaCorrente.toStringJSON());
            System.out.println("Conta Poupança:" + contaPoupanca.toStringJSON());
        }

    }

}
