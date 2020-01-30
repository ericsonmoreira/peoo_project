package util;

import java.util.ArrayList;

/**
 * Classe para representar uma Agenda.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Schedule {

	// Lista de pessoas (Contatos)
	private ArrayList<Pessoa> pessoas;
	 
	// Lista de mensagens.
	private ArrayList<Message> messages; 

	// Não acho interessante esse método ser público.
	protected ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	// Não acho interessante esse método ser público.
	protected void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	// Não acho interessante esse método ser público.
	private void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
	/**
	 * Construtor padão.
	 */
	public Schedule() {
		setPessoas(new ArrayList<Pessoa>());
		setMessages(new ArrayList<Message>());
	}
	
	/**
	 * Adiciona uma {@link Pessoa} na lista de Pessoas.
	 * @param pessoa
	 */
	public void addPessoa(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}
	
	/**
	 * Adiciona uma pessoa pelo nome e teledone dela.
	 * @param name Nome da pessoa.
	 * @param fone Telefone da pessoa.
	 */
	public void addPessoa(String name, String fone) {
		this.addPessoa(new Pessoa(name, fone));
	}
	
	/**
	 * Método para procurar pessoa pelo nome.
	 * 
	 * @param name Nome da pessoa.
	 * @return {@link Pessoa} ou <code>null</code>.
	 */
	public Pessoa searchPessoaForName(String name) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getName() == name) {
				return pessoa;
			}
		}
		return null;
	}
	/**
	 * Procurar pela pessoa pelo telefone.
	 * 
	 * @param name Nome da pessoa.
	 * @return {@link Pessoa} ou <code>null</code>.
	 */
	public Pessoa findPessoaForFone(String fone) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getFone() == fone) {
				return pessoa;
			}
		}
		return null;
	}
	
	/**
	 * Muda o telefone de uma pessoa da lista de pessoas.
	 * 
	 * @param name Nome da pessoa.
	 * @param newFone Novo telefone da pessoa.
	 * @return <code>true</code> caso consiga, <code>false</code> caso contrário.
	 */
	public boolean changeFonePessoa(String name, String newFone) {
		Pessoa pessoa = this.searchPessoaForName(name);
		if (pessoa != null) {
			pessoa.setFone(newFone);
			return true;
		}
		return false;
	}
	
	/**
	 * Remove uma pessoa da lista de pessoas procurando pelo nome.
	 * 
	 * @param name Nome da pessoa.
	 * @return <code>true</code> caso consiga, <code>false</code> caso contrário.
	 */
	public boolean removePessoa(String name) {
		Pessoa pessoa = this.searchPessoaForName(name);
		if (pessoa != null) {
			this.pessoas.remove(pessoa);
			return true;
		}
		return false;
	}
	
	/**
	 * Método para mostrar todas as pessoas da lista de {@link Pessoa}.
	 */
	public void showAllPessoas() {
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
	
	/**
	 * Enviar uma Mensagem recebendo o número do contato e a mensagem a ser enviada, e realiza o envio.
	 * Realizar o envio aqui será adicionar a mensagem na lista de mensagens.
	 * 
	 * @param foneContact Telefone do Contato.
	 * @param textMessage Texto da Mensagem.
	 * @return <code>true</code> caso consiga mandar a mensagem, <code>false</code> caso contrário.
	 */
	public boolean sendMessage(String foneContact, String textMessage) {
		Pessoa contact = this.findPessoaForFone(foneContact);
		if (contact != null) {
			Message message = new Message(contact, textMessage);
			this.messages.add(message);
			return true;
		} 
		return false;
	}

	
}
