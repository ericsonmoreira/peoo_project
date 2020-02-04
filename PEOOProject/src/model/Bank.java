package model;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.JSONable;

/**
 * Classe que Representa um Banco.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Bank extends JSONable {

	// Nome do Banco
	private String name;
	
	// Lista de Contas no banco.
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

	private void setAccounts(ArrayList<BankAccount> accounts) {
		this.accounts = accounts;
	}

	/**
	 * Adiciona uma {@link BankAccount} às contas do Banco.
	 * 
	 * @param account {@link BankAccount} a ser adicionada.
	 */
	public void addAccount(BankAccount account) {
		this.accounts.add(account);
	}
	
	/**
	 * Remover uma {@link BankAccount} das contas do Banco.
	 * 
	 * @param numAccount número da conta a ser removida.
	 * @return <code>true</code> caso a conta exista, <code>false</code> caso contrário.
	 */
	public boolean removeAccont(int numAccount) {
		BankAccount account = findAccount(numAccount);
		if (account != null) {
			this.accounts.remove(account);
		} else {
			return false;
		}
		return true;
	}
	
	public Bank(String name) {
		setName(name);
		setAccounts(new ArrayList<BankAccount>());
	}
	
	
	/**
	 * Construtor que recebeum {@link JSONObject}
	 * 
	 * @param jsonObject 
	 */
	@SuppressWarnings("unchecked")
	public Bank(JSONObject jsonObject) {
		this((String) jsonObject.get("name"));
		this.setAccounts((ArrayList<BankAccount>) jsonObject.get("accounts"));
	}

	/**
	 * Verifica se existe uma {@link BankAccount} no Banco.
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
	/**
	 * Usando JSON.
	 * 
	 * @return Um {@link JSONObject} - uma representação do objeto em JSON.
	 */
	@SuppressWarnings("unchecked")
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		JSONArray accounts = new JSONArray();
		this.accounts.forEach(a -> accounts.add(a.toJSONObject()));
		object.put("name", this.name);
		object.put("accounts", accounts);
		return object;
	}
	
}
