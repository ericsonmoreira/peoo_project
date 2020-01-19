package lesson_04.questions;

import util.BankAccount;
import util.Question;

/**
 * Refaça a classe Conta Bancária de forma que ela contenha dois construtores: um que inicializa todos 
 * seus atributos por parâmetro e outro que inicialize apenas o titular e o número por parâmetro e 
 * inicialize o saldo como 0 no corpo do construtor. Use a cláusula this. 
 * 
 * Altere a classe executável para refletir essa mudança
 * 
 * @author ericson
 *
 */
public class Question_01 extends Question{

	public static void main(String[] args) {

		System.out.println("Criando as Contas:");
		BankAccount account_01 = new BankAccount(10, "Ericson Moreira");				
		BankAccount account_02 = new BankAccount(20, "PEOO");
		
		
		// Dep�sitos.
		System.out.println("\n\n\nTestando Dep�sitos:");
		account_01.deposit(100);
		account_02.deposit(1000);
		account_02.deposit(-100);
		
		// Saques.
		System.out.println("\n\n\nTestando Saques:");
		account_01.withdraw(50);
		account_01.withdraw(10);
		account_01.withdraw(50);

		account_02.withdraw(500);
		account_02.withdraw(600);
		
		
		System.out.println("\n\n\nResiltado Final das Contas:");
		account_01.showBankAccount();
		account_02.showBankAccount();
	
	}

}
