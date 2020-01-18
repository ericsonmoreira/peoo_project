package lesson_02.questions;

import util.Question;

/**
 * 
 * @author Ericson Rogerio Moreira
 * 
 * Exerc�cio 1
 * 
 * 1) Fa�a um programa que receba dois n�meros reais (double), calcule e mostre a m�dia entre eles.
 * 
 * 2) Caso a m�dia seja maior que 7, mostrar a mensagem �Aprovado�, sen�o mostrar �Reprovado�.
 *
 */

public class Question_01 extends Question {

	public static void main(String[] args) {
		
		// Pegando o primeiro n�mero
		System.out.println("Digite o primeiro n�mero: ");
		double a = scanner.nextDouble();
		
		// Pegando o segundo n�mero.
		System.out.println("Digite o primeiro n�mero: ");
		double b = scanner.nextDouble();
		
		// M�dia
		double mean = (a + b)/2;
		
		System.out.println("M�dia: " + mean + ".");
		
		if (mean > 7) {
			System.out.println("Aprovado.");
		} else {
			System.out.println("Reprovado.");
		}

	}

}
