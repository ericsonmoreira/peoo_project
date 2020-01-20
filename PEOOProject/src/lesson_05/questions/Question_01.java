package lesson_05.questions;

import util.Banck;
import util.BankAccount;
import util.Question;

public class Question_01 extends Question {

	public static void main(String[] args) {
		
		Banck banck = new Banck("BB");
		
		// Cotas.
		BankAccount account01 = new BankAccount(1, "Andre", 1000);
		BankAccount account02 = new BankAccount(2, "Betina", 1000);
		BankAccount account03 = new BankAccount(3, "Carlos", 1000);
		BankAccount account04 = new BankAccount(4, "Daniel", 1000);
		BankAccount account05 = new BankAccount(5, "Ericson", 1000);
		BankAccount account06 = new BankAccount(6, "Fabio", 1000);
		BankAccount account07 = new BankAccount(7, "Guilherme", 1000);
		BankAccount account08 = new BankAccount(8, "Hugo", 1000);
		BankAccount account09 = new BankAccount(9, "Italo", 1000);
		BankAccount account10 = new BankAccount(10, "Jannerson", 1000);
		
		// Adicionando contas.
		banck.addAccount(account01);
		banck.addAccount(account02);
		banck.addAccount(account03);
		banck.addAccount(account04);
		banck.addAccount(account05);
		banck.addAccount(account06);
		banck.addAccount(account07);
		banck.addAccount(account08);
		banck.addAccount(account09);
		banck.addAccount(account10);
		
		// Procura pelo número da conta.
		BankAccount account = banck.findAccount(10);
	
		System.out.println(account.toString());
		
	}

}
