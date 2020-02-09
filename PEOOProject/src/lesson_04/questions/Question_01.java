package lesson_04.questions;

import model.Conta;
import util.Question;

/**
 * Refaça a classe Conta Bancária de forma que ela contenha dois construtores: um que inicializa todos
 * seus atributos por parâmetro e outro que inicialize apenas o titular e o número por parâmetro e
 * inicialize o saldo como 0 no corpo do construtor. Use a cláusula this.
 * <p>
 * Altere a classe executável para refletir essa mudança
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question_01 extends Question {

    public static void main(String[] args) {

        System.out.println("Criando as Contas:");
        Conta conta01 = new Conta(10, "Ericson Moreira");
        Conta conta02 = new Conta(20, "PEOO");

        // Depósitos.
        System.out.println("\n\n\nTestando Depósitos:");
        conta01.depositar(100);
        conta02.depositar(1000);
        conta02.depositar(-100);

        // Saques.
        System.out.println("\n\n\nTestando Saques:");
        conta01.sacar(50);
        conta01.sacar(10);
        conta01.sacar(50);
        conta02.sacar(500);
        conta02.sacar(600);

        System.out.println("\n\n\nResiltado Final das Contas:");
        conta01.showConta();
        conta02.showConta();

    }

}
