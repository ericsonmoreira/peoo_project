package lesson_02.questions;

import util.Question;

/**
 * 
 * @author Ericson Rogerio Moreira
 * 
 * Exercício 1
 * 
 * 1) Faça um programa que receba dois números reais (double), calcule e mostre a média entre eles.
 * 
 * 2) Caso a média seja maior que 7, mostrar a mensagem “Aprovado”, senão mostrar “Reprovado”.
 *
 */

public class Question_01 extends Question {

	public static void main(String[] args) {
		
		// Pegando o primeiro número
		System.out.println("Digite o primeiro número: ");
		double a = scanner.nextDouble();
		
		// Pegando o segundo número.
		System.out.println("Digite o primeiro número: ");
		double b = scanner.nextDouble();
		
		// Média
		double mean = (a + b)/2;
		
		System.out.println("Média: " + mean + ".");
		
		if (mean > 7) {
			System.out.println("Aprovado.");
		} else {
			System.out.println("Reprovado.");
		}

	}

}
