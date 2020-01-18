package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * Classe so para testes rápidos.
 * 
 * @author Ericson Rogerio Moreira.
 *
 */
public class Testando {

	public static Random random = new Random();
	
	public static void main(String[] args) {
		
		List<Integer> vetor = new ArrayList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			vetor.add(random.nextInt(100));
		}
		
		vetor.forEach(v -> System.out.println(v));
		
	}

}
