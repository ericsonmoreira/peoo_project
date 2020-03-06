package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.ContaCorrente;
import br.com.uece.peoo.model.ContaPoupanca;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Alterar a classe Conta para ter seus atributos protegido.
 * Criar a subclasse ContaCorrente, com atributo limite e método debitarAnuidade, que debita 50 reais do saldo.
 * Criar a subclasse ContaPoupança, com atributo taxaRendimento e método render, que incrementa o saldo em taxaRendimento%
 * Criar objetos das subclasses na classe Main e usar seus métodos
 */
public class Question07_01 {

    public static List<String> meses = Arrays.asList("JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ");

    public static void main(String[] args) {

        // Criando conta corrente.
        ContaCorrente contaCorrente = new ContaCorrente(1, "Ericson Rogerio Moreira", 1000, 100);

        // Criando conta poupança.
        ContaPoupanca contaPoupanca = new ContaPoupanca(2, "Marilia Gabriela", 1000, 0.05);

        System.out.println("Ano Passado:");
        System.out.println("Conta Corrente: " + contaCorrente);
        System.out.println("Conta Poupança: " + contaPoupanca);

        meses.forEach(mes -> {
            contaCorrente.debitarAnuidade();
            contaPoupanca.render();
            System.out.println(mes);
            System.out.println("Conta Corrente:" + contaCorrente.toStringJSON());
            System.out.println("Conta Poupança:" + contaPoupanca.toStringJSON());
        });


    }

}
