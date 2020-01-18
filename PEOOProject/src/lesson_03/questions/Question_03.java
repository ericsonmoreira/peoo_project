package lesson_03.questions;

import java.util.ArrayList;

import util.Question;

/**
 * 
 * 3. Fa�a um algoritmo que leia um vetor de inteiros de 10 posi��es: 
 * 		a. Informe se existe algum n�mero repetido e que n�mero � esse
 * 		b. Informe quantos n�meros menores do que 0 existem no vetor
 * 		c. Informe a soma de todos os n�meros do vetor
 * 		d. Imprima o vetor em ordem inversa.
 * 		e. Ordene o vetor de menor para o maior n�mero
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class Question_03 extends Question{

	/**
	 * M�todo para verificar se h� elementos repetidos em um vetor de inteiros.
	 * [a. Informe se existe algum n�mero repetido e que n�mero � esse]
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
	 * M�todo para retornar a quantidade de elementos menores que zero em um vetor de interiros.
	 * [b. Informe quantos n�meros menores do que 0 existem no vetor]
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
	 * M�toro para pegar somar todos os elementos de um vetor e retornar essa soma.
	 * [c. Informe a soma de todos os n�meros do vetor]
	 * @param D Vetor de inteiros.
	 * @return Somat�rio dos elementos do vetor D.
	 */
	public static int sunAll(int D[]) {
		// Vari�vel para armazenar o somat�rio.
		int sun = 0;
		for (int i = 0; i < D.length; i++) {
			sun += D[i];
		}
		return sun;
	}

	/**
	 * M�todo que recebe um vetor de inteiros e inverte ele.
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
	 * Oredena��o Bolha para um vetor de inteiros s� que ao contr�rio.
	 * [e. Ordene o vetor de menor para o maior n�mero]
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

		// Vetor de inteiros com 10 posi��es.
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
		// a. Informe se existe algum n�mero repetido e que n�mero � esse
		System.out.println("*****************************************************");
		System.out.println("N�meros repetidos: ");
		
		ArrayList<Integer> rElem = repeatedElements(D);
		if (rElem.isEmpty()) {
			System.out.println("Sem elementos repetidos.");
		} else {
			for (Integer element : rElem) {
				System.out.println(element);
			}
		}
		System.out.println("*****************************************************");
		
		// b. Informe quantos n�meros menores do que 0 existem no vetor
		System.out.println("*****************************************************");
		System.out.println("Quantidade de n�meros menores que Zero:");
		System.out.println(countSmallestZero(D));
		System.out.println("*****************************************************");
		
		// c. Informe a soma de todos os n�meros do vetor
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
		
		// e. Ordene o vetor de menor para o maior n�mero
		System.out.println("*****************************************************");
		System.out.println("Vetor ordenado em ordem decrescente:");
		bubbleSortReverse(D);
		printArray(D);
		System.out.println("*****************************************************");
		
	}

}
