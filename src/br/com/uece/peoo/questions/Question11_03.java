package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Calculadora;
import br.com.uece.peoo.model.Elevador;
import br.com.uece.peoo.util.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe com main que instancia um elevador e simula o seu uso em um prédio.
 */
public class Question11_03 {

    public static Elevador elevador;

    public static Menu menu;

    public static void init() {

        // Elevador com 11 andares (terreo + 10) e capacidade de 6 pessoas.
        elevador = new Elevador(6, 10);
        menu = new Menu();

        // Adicionando aqui as opções para o menu interativo.
        menu.addOption(1, "Entrar", () -> {
            if (!elevador.entra()) {
                System.err.println("Erro ao tentar Entrar");
            }
        });

        menu.addOption(2, "Sair", () -> {
            if (!elevador.sai()) {
                System.err.println("Erro ao tentar Sair");
            }
        });

        menu.addOption(3, "Subir", () -> {
            if (!elevador.sobe()) {
                System.err.println("Erro ao tentar Subir");
            }
        });

        menu.addOption(4, "Descer", () -> {
            if (!elevador.entra()) {
                System.err.println("Erro ao tentar Descer");
            }
        });

        menu.addOption(5, "Ir para um Andar", () -> {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o andar desejado");
                int andar = scanner.nextInt();
                if (!elevador.irAndar(andar)) {
                    System.err.println("Andar: " + andar + " inválido.");
                }
            } catch (Exception e) {
                System.err.println("Valor Invalido");
            }
        });

        menu.addOption(99, "Fechar Programa", () -> System.exit(0));
    }

    public static void main(String[] args) {

        init();

        System.out.println(elevador);

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
            System.out.println(elevador);
        }
    }
}
