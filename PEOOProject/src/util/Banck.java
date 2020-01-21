package util;

import java.util.ArrayList;

public class Banck {

	private String name;
	
	private ArrayList<BankAccount> accounts;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<BankAccount> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(BankAccount account) {
		this.accounts.add(account);
	}
	
	public Banck(String name) {
		setName(name);
		setAccounts(new ArrayList<BankAccount>());
	}

	/**
	 * Verifica se existe uma {@link BankAccount} é uma conta do Banco.
	 * 
	 * @param numAccount Número da conta.
	 * @return uma instância de {@link BankAccount} caso ela faça parte das contas do Banco. Caso contrário, <code>null</code>. 
	 */
	public BankAccount findAccount(int numAccount) {
		for (BankAccount bankAccount : this.accounts) {
			if (bankAccount.getNumAccount() == numAccount) {
				return bankAccount;
			}
		}
		return null;
	}
	
	/**
	 * Transfere um valor de uma conta para outra. 
	 * Caso a contra devedora não tenha dinheiro suficiente, a transf. não poderá ser realizada
	 * 
	 * @param debtor {@link BankAccount} de onde sai o dinheiro.
	 * @param creditor {@link BankAccount} para onde vai o dinheiro.
	 * @param value Valor a ser transferido.
	 * @return <code>true</code> caso seja possível transferir. 
	 */
	public boolean transfer(BankAccount debtor, BankAccount creditor, double value) {
		if (debtor.getBalance() >= value) {
			debtor.setBalance(debtor.getBalance() - value);
			creditor.setBalance(creditor.getBalance() + value);
			// Transferência deu certo.
			return true;
		}
		// Transferência não deu certo.
		return false;
	}
	
	
}
