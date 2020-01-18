package lesson_03.questions;

import util.Question;

/**
 * 
 * @author Ericson Rogerio Moreira
 * 1. As ma��s custam R$ 1,30 cada se forem compradas menos de uma d�zia, e R$ 1,00 cada se 
 * forem compradas pelo menos uma d�zia. Escreva um programa que leia o n�mero de ma��s 
 * compradas, calcule e escreva o custo total da compra.
 *
 */
public class Question_01 extends Question{
	
	/**
	 * 
	 * @param numApples N�mero de ma��s.
	 * @return Pre�o das ma��s de acordo com a quest�o.
	 */
	private static double priceApples(int numApples) {
		if (numApples >= 12) 
			return numApples * 1.0;
		else 
			return numApples * 1.3;
		
	}
	
	public static void main(String[] args) {

		System.out.println("Digite o n�mero de ma��s:");
		int numApples = scanner.nextInt();
		
		// Calculando o pre�o das ma��s.
		double p = priceApples(numApples);
		System.out.println("Toral a pagar: R$ " + p + ".");
		
		
	}

}
