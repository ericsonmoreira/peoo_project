package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Calculadora;
import br.com.uece.peoo.util.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question11_01 {
    public static Calculadora calculadora;

    public static Menu menu;

    public static void init() {

        calculadora = new Calculadora();
        menu = new Menu();

        menu.addOption(1, "Somar", () -> {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o Valor");
                double valor = scanner.nextDouble();
                calculadora.adicao(valor);
            } catch (InputMismatchException e) {
                System.err.println("Valor Inválido.");
            }
        });

        menu.addOption(2, "Subitrair", () -> {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o Valor");
                double valor = scanner.nextDouble();
                calculadora.subitracao(valor);
            } catch (InputMismatchException e) {
                System.err.println("Valor Inválido.");
            }
        });

        menu.addOption(3, "Multiplicar", () -> {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o Valor");
                double valor = scanner.nextDouble();
                calculadora.multiplicacao(valor);
            } catch (InputMismatchException e) {
                System.err.println("Valor Inválido.");
            }
        });

        menu.addOption(4, "Dividir", () -> {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o Valor");
                double valor = scanner.nextDouble();
                calculadora.divisao(valor);
            } catch (InputMismatchException e) {
                System.err.println("Valor Inválido.");
            }
        });

        menu.addOption(5, "C", () -> calculadora.limparValorAcumulado());

        menu.addOption(99, "Sair", () -> System.exit(0));
    }

    public static void main(String[] args) {

        init();

        System.out.println("Último Valor: " + calculadora.getUltimoResultado());

        while (true) {
            Scanner scanner = new Scanner(System.in);
            menu.printMenu();
            System.out.println("Digite a opção:");
            try {
                int op = scanner.nextInt();
                menu.getRunnable(op).run();
            } catch (InputMismatchException | NullPointerException err) {
                System.err.println("Opção invalida");
            }
            System.out.println("Último Valor: " + calculadora.getUltimoResultado());
        }
    }
}
