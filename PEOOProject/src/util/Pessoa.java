package util;

/**
 * Obs.: O nome dessa classe está em português porque já existe uma classe com o nome Person nesse pacote.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Pessoa {

	private String name;
	
	private String fone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * Construtor genérico que cria a classe com os atributos com {@link String} vazias.
	 */
	public Pessoa() {
		this("", "");
	}

	/**
	 * Construtor com atributos.
	 * 
	 * @param name Nome da pessoa.
	 * @param fone Telefone da pessoa.
	 */
	public Pessoa(String name, String fone) {
		setName(name);
		setFone(fone);
	}
	
	@Override
	public String toString() {
		return "[Nome: " + this.name + ", telefone: " + this.fone + "]";
	}
	
}
