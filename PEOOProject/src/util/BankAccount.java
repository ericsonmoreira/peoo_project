package util;

/**
 * 
 * Classe para representar uma Conta Bancária.
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
	 * Método para Depositar.
	 * 
	 * @param value valor a ser depositado.
	 */
	public void deposit(double value) {
		// Um depósito não pode ser negativo.
		if(value < 0) {
			System.err.println("Deposíto não pode ser negativo!!! Valor do Deposito: " + Question.numberFormat.format(value) + ".");
		} else {
			this.balance += value;
			System.out.println("Deposíto realizado. Saldo: " + Question.numberFormat.format(value));
		}
		// Mostrando a conta.
		this.showBankAccount();
	}

	/**
	 * 
	 * Método para sacar.
	 * 
	 * @param value valor a ser sacado.
	 */
	public void withdraw(double value) {
		// Saldo da conta não pode ser negativo.
		System.out.println("----------------------------------------------------------------");
		if (this.balance < value) {
			System.err.println("Saldo na conta não pode ser negativo!");
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
	 * Construtor genérico.
	 */
	public BankAccount() {
		this(-1, "", 0);
	}

	/**
	 * @param numAccount número da conta.
	 * @param holder titular da conta.
	 * @param balance saldo da conta.
	 */
	public BankAccount(int numAccount, String holder) {
		this(numAccount, holder, 0);
	}
	
	/**
	 * @param numAccount número da conta.
	 * @param holder titular da conta.
	 * @param balance saldo da conta.
	 */
	public BankAccount(int numAccount, String holder, double balance) {
		setNumAccount(numAccount);
		setBalance(balance);
		setHolder(holder);
		System.out.println("------------------- Nova Conta ---------------------------------");
		System.out.println("Nova Conta adicionada com sucesso.");
		this.showBankAccount();
		System.out.println("----------------------------------------------------------------");
	}
	
	/**
	 * Imprime um resumo da {@link BankAccount}.
	 */
	public void showBankAccount() {
		System.out.println("--------------------- Sua Conta --------------------------------");
		System.out.println("[NumConta: " + this.numAccount + "]");
		System.out.println("[Titular: : " + this.holder + "]");
		System.out.println("[Saldo: " + this.balance + "]");
		System.out.println("----------------------------------------------------------------");
	}
		
}
