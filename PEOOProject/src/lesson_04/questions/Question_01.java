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
        Conta account_01 = new Conta(10, "Ericson Moreira");
        Conta account_02 = new Conta(20, "PEOO");


        // Depósitos.
        System.out.println("\n\n\nTestando Depósitos:");
        account_01.depositar(100);
        account_02.depositar(1000);
        account_02.depositar(-100);

        // Saques.
        System.out.println("\n\n\nTestando Saques:");
        account_01.sacar(50);
        account_01.sacar(10);
        account_01.sacar(50);

        account_02.sacar(500);
        account_02.sacar(600);


        System.out.println("\n\n\nResiltado Final das Contas:");
        account_01.showConta();
        account_02.showConta();

    }

}
