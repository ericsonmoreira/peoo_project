package br.com.uece.peoo.questions;

import br.com.uece.peoo.util.Question;

/**
 * 1. As maçãs custam R$ 1,30 cada se forem compradas menos de uma dúzia, e R$ 1,00 cada se
 * forem compradas pelo menos uma dúzia. Escreva um programa que leia o número de maçãs
 * compradas, calcule e escreva o custo total da compra.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question02_01 extends Question {

    /**
     * @param numApples Número de maçãs.
     * @return Preço das maçãs de acordo com a questão.
     */
    private static double priceApples(int numApples) {
        if (numApples >= 12)
            return numApples * 1.0;
        else
            return numApples * 1.3;

    }

    public static void main(String[] args) {

        System.out.println("Digite o número de maçãs:");
        int numApples = scanner.nextInt();

        // Calculando o preço das maçãs.
        double p = priceApples(numApples);
        System.out.println("Toral a pagar: R$ " + p + ".");


    }

}
