package lesson_02.questions;

import util.Question;

/**
 * 
 * @author Ericson Rogerio Moreira
 * 
 * ExercÃ­cio 1
 * 
 * 1) FaÃ§a um programa que receba dois nÃºmeros reais (double), calcule e mostre a mÃ©dia entre eles.
 * 
 * 2) Caso a mÃ©dia seja maior que 7, mostrar a mensagem â€œAprovadoâ€�, senÃ£o mostrar â€œReprovadoâ€�.
 *
 */

public class Question_01 extends Question {

	public static void main(String[] args) {
		
		// Pegando o primeiro nÃºmero
		System.out.println("Digite o primeiro nÃºmero: ");
		double a = scanner.nextDouble();
		
		// Pegando o segundo nÃºmero.
		System.out.println("Digite o primeiro nÃºmero: ");
		double b = scanner.nextDouble();
		
		// MÃ©dia
		double mean = (a + b)/2;
		
		System.out.println("MÃ©dia: " + mean + ".");
		
		if (mean > 7) {
			System.out.println("Aprovado.");
		} else {
			System.out.println("Reprovado.");
		}
		// Testando o Git.
		// Alterado do Eclipse.

	}

}
