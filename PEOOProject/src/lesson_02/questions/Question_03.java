package lesson_02.questions;

import util.Question;

/**
 * 
 * @author Ericson Rogerio Moreira
 * Exercício 3 
 * 
 * 1) Faça um programa que peça ao usuário para entrar com 7 números inteiros e armazene-os em um vetor. Peça também para
 * ele entrar com outro número inteiro X e determine se X está no vetor e em que posição. 
 * 
 * 2) Considerando o vetor da questão anterior, verifique se os números estão em ordem crescente. Caso contrário, ordene e 
 * imprima o vetor.
 * 
 */
public class Question_03 extends Question {

	/**
	 * 
	 * @param numbers Lista de números.
	 * @return Retorna <code>true</code> se a lista está ordenada, caso contrário, retorna <code>false</code>.
	 */
	private static boolean isGrowing(int[] numbers) {
		// Analisa a lista dois a dois em ordem crescente.
		for (int i = 0; i < numbers.length - 1; i++) {
			// Se o i-ésimo número for maior que o seu próximo, então retorna false.
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		// Se chegou aqui é pq a lista está ordenada.
		return true;
	}

	/**
	 * 
	 * Método de ordenação bolha (Bubble Sort).
	 * 
	 * @param numbers Lista números a serem ordenados.
	 */
	private static void bubbleSort(int[] numbers) {
		for(int i = 0; i < numbers.length; i++){
			for(int j = 0; j < numbers.length - 1; j++){
				if(numbers[j] > numbers[j + 1]){
					int aux = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = aux;
				}
			}
		}

	}

	/**
	 * 
	 * @param x Número a se procurado.
	 * @param numbers Lista de busca.
	 * @return Retorna a posição do número procurado, caso ele esteja presente na lista, caso contrário, retorna -1.
	 */
	private static int searchInt(int x, int[] numbers) {
		for (int i = 0; i < numbers.length; i++) if (numbers[i] == x) return i;
		return -1;
	}

	public static void main(String[] args) {

		// Criando a lista de 7 interiros.
		int numbers[] = new int[7];

		// Preenche a Lista com os números digitados.
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Digire o N[" + i + "]:" );
			numbers[i] = scanner.nextInt();
		}

		System.out.println("Digite o numero a ser procurado:");
		int x = scanner.nextInt();

		int position = searchInt(x, numbers);
		if (position != -1) {
			System.out.println("O número " + x + " foi encontrado na posição " + position + ".");
		} else {
			System.out.println("O número " + x + " não foi encontrado na lista.");
		}

		if (isGrowing(numbers)) {
			System.out.println("A lista é crescent.");
		} else {
			System.out.println("A lista não é crescent.");
			bubbleSort(numbers);
			System.out.println("Lista ordenada: ");
			for (int i = 0; i < numbers.length; i++) {
				System.out.println(numbers[i]);
			}
		}

	}

}
