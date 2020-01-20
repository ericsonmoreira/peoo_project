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

	public BankAccount findAccount(int numAccount) {
		// TODO Auto-generated method stub
		for (BankAccount bankAccount : this.accounts) {
			if (bankAccount.getNumAccount() == numAccount) {
				return bankAccount;
			}
		}
		return null;
	}
	
}
