package util;

/**
 * 
 * Classe para representar uma Conta Banc�ria.
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class BankAccount {

	// N�mero da conta.
	private int numAccount;
	
	// Titular da conta.
	private String holder;
	
	// Saldo da conta.
	private double balance;

	public int getNumAccount() {
		return numAccount;
	}

	public void setNumAccount(int numAccount) {
		this.numAccount = numAccount;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * M�todo para Depositar.
	 * 
	 * @param value valor a ser depositado.
	 */
	public void deposit(double value) {
		// Um dep�sito n�o pode ser negativo.
		if(value < 0) {
			System.err.println("Dep�sito n�o pode ser negativo!!! Valor do Deposito: " + Question.numberFormat.format(value) + ".");
		} else {
			this.balance += value;
			System.out.println("Dep�sito realizado. Saldo: " + Question.numberFormat.format(value));
		}
		// Mostrando a conta.
		this.showBankAccount();
	}

	/**
	 * 
	 * M�todo para sacar.
	 * 
	 * @param value valor a ser sacado.
	 */
	public void withdraw(double value) {
		// Saldo da conta n�o pode ser negativo.
		System.out.println("----------------------------------------------------------------");
		if (this.balance < value) {
			System.err.println("Saldo na conta n�o pode ser negativo!");
			System.err.println("Saldo: " + Question.numberFormat.format(this.balance) + ".");
			System.err.println("Saque: " + Question.numberFormat.format(value));
		} else {
			
			System.out.println("Saque realizado. Valor: " + Question.numberFormat.format(value));
			this.balance -= value;
		}
		System.out.println("----------------------------------------------------------------");
		// Mostrando a conta.
		this.showBankAccount();
				
	}
	
	/**
	 * Construtor gen�rico.
	 */
	public BankAccount() {
		this(-1, "");
		setBalance(0);
	}

	/**
	 * 
	 * @param numAccount
	 * @param holder
	 */
	public BankAccount(int numAccount, String holder) {
		setNumAccount(numAccount);
		setBalance(0);
		setHolder(holder);
		System.out.println("------------------- Nova Conta ---------------------------------");
		System.out.println("Nova Conta adicionada com sucesso.");
		this.showBankAccount();
		System.out.println("----------------------------------------------------------------");
		
	}

	public void showBankAccount() {
		System.out.println("--------------------- Sua Conta --------------------------------");
		System.out.println("[NumConta: " + this.numAccount + "]");
		System.out.println("[Titular: : " + this.holder + "]");
		System.out.println("[Saldo: " + this.balance + "]");
		System.out.println("----------------------------------------------------------------");
	}
		
}
