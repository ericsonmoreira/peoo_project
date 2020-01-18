package lesson_02.questions;

import util.Question;

/**
 * 
 * @author Ericson Rogerio Moreira
 * Exerc�cio 3 
 * 
 * 1) Fa�a um programa que pe�a ao usu�rio para entrar com 7 n�meros inteiros e armazene-os em um vetor. Pe�a tamb�m para
 * ele entrar com outro n�mero inteiro X e determine se X est� no vetor e em que posi��o. 
 * 
 * 2) Considerando o vetor da quest�o anterior, verifique se os n�meros est�o em ordem crescente. Caso contr�rio, ordene e 
 * imprima o vetor.
 * 
 */
public class Question_03 extends Question {

	/**
	 * 
	 * @param numbers Lista de n�meros.
	 * @return Retorna <code>true</code> se a lista est� ordenada, caso contr�rio, retorna <code>false</code>.
	 */
	private static boolean isGrowing(int[] numbers) {
		// Analisa a lista dois a dois em ordem crescente.
		for (int i = 0; i < numbers.length - 1; i++) {
			// Se o i-�simo n�mero for maior que o seu pr�ximo, ent�o retorna false.
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		// Se chegou aqui � pq a lista est� ordenada.
		return true;
	}

	/**
	 * 
	 * M�todo de ordena��o bolha (Bubble Sort).
	 * 
	 * @param numbers Lista n�meros a serem ordenados.
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
	 * @param x N�mero a se procurado.
	 * @param numbers Lista de busca.
	 * @return Retorna a posi��o do n�mero procurado, caso ele esteja presente na lista, caso contr�rio, retorna -1.
	 */
	private static int searchInt(int x, int[] numbers) {
		for (int i = 0; i < numbers.length; i++) if (numbers[i] == x) return i;
		return -1;
	}

	public static void main(String[] args) {

		// Criando a lista de 7 interiros.
		int numbers[] = new int[7];

		// Preenche a Lista com os n�meros digitados.
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Digire o N[" + i + "]:" );
			numbers[i] = scanner.nextInt();
		}

		System.out.println("Digite o numero a ser procurado:");
		int x = scanner.nextInt();

		int position = searchInt(x, numbers);
		if (position != -1) {
			System.out.println("O n�mero " + x + " foi encontrado na posi��o " + position + ".");
		} else {
			System.out.println("O n�mero " + x + " n�o foi encontrado na lista.");
		}

		if (isGrowing(numbers)) {
			System.out.println("A lista � crescent.");
		} else {
			System.out.println("A lista n�o � crescent.");
			bubbleSort(numbers);
			System.out.println("Lista ordenada: ");
			for (int i = 0; i < numbers.length; i++) {
				System.out.println(numbers[i]);
			}
		}

	}

}
