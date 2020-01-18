package lesson_03.questions;

import util.Question;


/**
 * 4. Faça um algoritmo que leia a quantidade de dinheiro existente no caixa de uma	
 * empresa, a quantidade de produtos a ser comprada e o preço de cada unidade. 
 * Caso o valor total da compra seja superior a 80% do valor em caixa, a compra 
 * deve ser feita a prazo (3x), com juros de 10% sobre o valor total. Caso contrário, 
 * a compra deverá ser realizada a vista, onde a empresa receberá 5% de desconto. 
 * Apresentar a forma de pagamento e o valor a ser pago (total a vista ou total a prazo), 
 * dependendo da escolha realizada;
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class Question_04 extends Question {

	public static void main(String[] args) {

		System.out.println("Digite a quantidade de $$$ no caixa da Empresa:");
		double money  = scanner.nextDouble();
		
		System.out.println("Digite a quantidade de produtos a ser comprada:");
		int quantProducts = scanner.nextInt();
		
		System.out.println("Digite o preço de cada unidade:");
		double priceProduct = scanner.nextDouble();
		
		// Total do valor da compra.
		double totalPrice = quantProducts * priceProduct;
		
		// Valor a do pagamento.
		double paymentAmount = (totalPrice > 0.8 * money) ? totalPrice * 1.1: totalPrice * 0.95;  
				
		// Classe para formatar o valor em R$ *.***,00. 
		
		
		// Forma de pagamento.
		String formOfPayment = (totalPrice > 0.8 * money) ? "A prazo (3x), com juros de 10% sobre o valor total": "A vista, com 5% de desconto";
		System.out.println("Total a ser pago: " + numberFormat.format(paymentAmount) + ".");
		System.out.println("Forma de Pagamento: " + formOfPayment + ".");
		
	}

}
