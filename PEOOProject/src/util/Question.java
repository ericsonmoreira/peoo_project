package util;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Classe para abistrair funcionalidades das questões.
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class Question {
	
	// Atributos estáticos que geramente são usados nas questões.
	public static Scanner scanner = new Scanner(System.in);
	public static NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
	
	/**
	 * Método auxiliar para poder imprimir um vetor de inteiros.
	 * 
	 * @param D vetor de inteiros.
	 */
	public static void printArray(int D[]) {
		String aux = "D";
		for (int i : D) {
			aux += "[" + i + "]";
		}
		System.out.println(aux);
	}
	
}
