package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * Classe so para testes rápidos.
 * 
 * Como usar "method reference" e forEach.
 * 
 * @author Ericson Rogerio Moreira.
 *
 */
public class Testando {

	// seed = 20
	public static Random random = new Random(20);
	
	public static void main(String[] args) {
		
		List<Integer> vetor = new ArrayList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			vetor.add(random.nextInt(100));
		}
		
		// Imprime todos os elementos da Lista.
		vetor.forEach(v -> System.out.println(v));
		
		// Imprime todos os elementos da Lista.
		vetor.forEach(System.out::print);
		
		
		// filtra os elementos do vetor que são maiores ou iguais a 50 e imprime.
		// o metoso stream() retorna um stream dos elementos da lista
		vetor.stream().filter(v -> v >= 50).forEach(v -> System.out.println("[" + v + "]"));
		
		
	}
	
}
