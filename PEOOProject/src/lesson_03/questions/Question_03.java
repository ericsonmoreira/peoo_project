package lesson_03.questions;

import java.util.ArrayList;

import util.Question;

/**
 * 
 * 3. Faça um algoritmo que leia um vetor de inteiros de 10 posições: 
 * 		a. Informe se existe algum número repetido e que número é esse
 * 		b. Informe quantos números menores do que 0 existem no vetor
 * 		c. Informe a soma de todos os números do vetor
 * 		d. Imprima o vetor em ordem inversa.
 * 		e. Ordene o vetor de menor para o maior número
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class Question_03 extends Question{

	/**
	 * Método para verificar se há elementos repetidos em um vetor de inteiros.
	 * [a. Informe se existe algum número repetido e que número é esse]
	 * 
	 * @param D Vetor de inteiros para verificar.
	 * @return {@link ArrayList} de {@link Integer} contendo os elementos repetidos.
	 */
	public static ArrayList<Integer> repeatedElements(int D[]){

		ArrayList<Integer> repeated = new ArrayList<Integer>(); 
		
		for (int i = 0; i < D.length - 1; i++) {
			for (int j = i; j < D.length - 1; j++) {
				if (D[j] == D[j + 1] && !repeated.contains(D[j])) {
					repeated.add(D[j]);
				}
			}
		}
		return repeated;
	}

	/**
	 * Método para retornar a quantidade de elementos menores que zero em um vetor de interiros.
	 * [b. Informe quantos números menores do que 0 existem no vetor]
	 * 
	 * @param D Vetor de interiros.
	 * @return Quantidade de elementos menores que 0 no vetor.
	 */
	public static int countSmallestZero(int D[]) {
		int smallest = 0;
		for (int i = 0; i < D.length; i++) {
			if (D[i] == 0) {
				smallest++;
			}
		}
		return smallest;
	}
	/**
	 * Métoro para pegar somar todos os elementos de um vetor e retornar essa soma.
	 * [c. Informe a soma de todos os números do vetor]
	 * @param D Vetor de inteiros.
	 * @return Somatório dos elementos do vetor D.
	 */
	public static int sunAll(int D[]) {
		// Variável para armazenar o somatório.
		int sun = 0;
		for (int i = 0; i < D.length; i++) {
			sun += D[i];
		}
		return sun;
	}

	/**
	 * Método que recebe um vetor de inteiros e inverte ele.
	 * 
	 * @param D vetor de inteitos.
	 */
	public static void reverseArray(int[] D) {
		int aux;
		for (int i = 0; i < D.length/2; i++) {
			aux = D[i];
			D[i] = D[D.length - i - 1];
			D[D.length - i - 1] = aux;
		}
	}
	
	/**
	 * Oredenação Bolha para um vetor de inteiros só que ao contrário.
	 * [e. Ordene o vetor de menor para o maior número]
	 * 
	 * @param D Vetor de inteiros.
	 */
	public static void bubbleSortReverse(int D[]){
		for(int i = 0; i < D.length; i++){
			for(int j = 0; j<D.length - 1; j++){
				if(D[j] < D[j + 1]){
					int aux = D[j];
					D[j] = D[j+1];
					D[j+1] = aux;
				}
			}
		}

	}
	
	public static void main(String[] args) {

		// Vetor de inteiros com 10 posições.
		int D[] = new int[10];

		// Preenchendo o vetor.
		for (int i = 0; i < D.length; i++) {
			System.out.println("Digite o valor de D[" + i +"]:");
			D[i] = scanner.nextInt();
		}
		
		// Imprimindo o vetor.
		System.out.println("*****************************************************");
		System.out.println("Valores recebidos:");
		printArray(D);
		System.out.println("*****************************************************");
		// a. Informe se existe algum número repetido e que número é esse
		System.out.println("*****************************************************");
		System.out.println("Números repetidos: ");
		
		ArrayList<Integer> rElem = repeatedElements(D);
		if (rElem.isEmpty()) {
			System.out.println("Sem elementos repetidos.");
		} else {
			for (Integer element : rElem) {
				System.out.println(element);
			}
		}
		System.out.println("*****************************************************");
		
		// b. Informe quantos números menores do que 0 existem no vetor
		System.out.println("*****************************************************");
		System.out.println("Quantidade de números menores que Zero:");
		System.out.println(countSmallestZero(D));
		System.out.println("*****************************************************");
		
		// c. Informe a soma de todos os números do vetor
		System.out.println("*****************************************************");
		System.out.println("Soma de todos os elementos do vetor:");
		System.out.println(sunAll(D));
		System.out.println("*****************************************************");
		
		// d. Imprima o vetor em ordem inversa.
		System.out.println("*****************************************************");
		System.out.println("Vetor em ondem inversa:");
		reverseArray(D);
		printArray(D);
		System.out.println("*****************************************************");
		
		// e. Ordene o vetor de menor para o maior número
		System.out.println("*****************************************************");
		System.out.println("Vetor ordenado em ordem decrescente:");
		bubbleSortReverse(D);
		printArray(D);
		System.out.println("*****************************************************");
		
	}

}
