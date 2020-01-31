package util;

import java.lang.reflect.Field;

import org.json.simple.JSONObject;


/**
 * 
 * Classe para representar uma Conta Bancária.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class BankAccount {

	// Número da conta.
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
	 * @return <code>true</code> sucesso, <code>false</code> erro.
	 */
	public boolean deposit(double value) {
		// Um depósito não pode ser negativo.
		if(value < 0) {
			System.err.println("Deposíto não pode ser negativo!!! Valor do Deposito: " + Question.numberFormat.format(value) + ".");
			return false;
		} else {
			this.balance += value;
			System.out.println("Deposíto realizado. Saldo: " + Question.numberFormat.format(value));
		}
		// Mostrando a conta.
		this.showBankAccount();
		return true;
	}

	/**
	 * Método para sacar.
	 * 
	 * @param value valor a ser sacado.
	 * @return <code>true</code> sucesso, <code>false</code> erro.
	 */
	public boolean withdraw(double value) {
		// Saldo da conta não pode ser negativo.
		System.out.println("----------------------------------------------------------------");
		if (this.balance < value) {
			System.err.println("Saldo na conta não pode ser negativo!");
			System.err.println("Saldo: " + Question.numberFormat.format(this.balance) + ".");
			System.err.println("Saque: " + Question.numberFormat.format(value));
			return false;
		} else {
			System.out.println("Saque realizado. Valor: " + Question.numberFormat.format(value));
			this.balance -= value;
		}
		System.out.println("----------------------------------------------------------------");
		// Mostrando a conta.
		this.showBankAccount();
		return true;
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
		this.showBankAccount();
		System.out.println("Nova Conta adicionada com sucesso.");
		System.out.println("----------------------------------------------------------------");
	}
	
	/**
	 * Imprime um resumo da {@link BankAccount}.
	 */
	public void showBankAccount() {
		System.out.println("--------------------- Sua Conta --------------------------------");
		System.out.println(this);
		System.out.println("----------------------------------------------------------------");
	}
	
	@Override
	public String toString() {
		return "[NumConta: " + this.numAccount + ";"
				+ " Titular: " + this.holder + ";"
				+ " Saldo: " + Question.numberFormat.format(this.balance) + "]";
	}
	
	/**
	 * Usando JSON.
	 * 
	 * @return Um {@link JSONObject} - uma representação do objeto em JSON.
	 */
	@SuppressWarnings("unchecked")
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put("numAccount", this.numAccount);
		object.put("holder", this.holder);
		object.put("balance", this.balance);
		return object;
	}

	/**
	 * 
	 * @return {@link String} no padrão JSON.
	 */
	public String toStringJSON() {
		JSONObject object = this.toJSONObject();
		return object.toJSONString();
	}
	
//	public static void main(String[] args) {
//		BankAccount account = new BankAccount(1, "Ericson Rogerio Moreira", 1000);
//		
//		System.out.println(account.toStringJSON());
//	}
	
}
