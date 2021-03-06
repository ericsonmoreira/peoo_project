package br.com.uece.peoo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe so para testes rápidos.
 *
 * Como usar "method reference" e forEach.
 *
 */
public class Testando {

    // seed = 20
    public static Random random = new Random(20);
    private static Scanner scanner;

    public static void testeScanner() {
        scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(string);
    }

    public static void main(String[] args) {
//		testeScanner();
        List<Integer> vetor = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            vetor.add(random.nextInt(100));
        }

        // Imprime todos os elementos da Lista.
        // vetor.forEach(System.out::println); // Também pode fazer assim.
        vetor.forEach(v -> System.out.println(v));

        // Imprime todos os elementos da Lista.
        vetor.forEach(System.out::print);


        // filtra os elementos do vetor que são maiores ou iguais a 50 e imprime.
        // o metoso stream() retorna um stream dos elementos da lista
        vetor.stream().filter(v -> v >= 50).forEach(v -> System.out.println("[" + v + "]"));
        vetor.stream().sorted().forEach(integer -> System.out.println(integer));
        vetor.stream().map(integer -> integer * 2).filter(integer -> integer > 100).forEach(integer -> System.out.println(integer));

    }

}
