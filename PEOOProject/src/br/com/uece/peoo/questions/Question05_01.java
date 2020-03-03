package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Agenda;
import br.com.uece.peoo.model.ContatoInfancia;
import br.com.uece.peoo.model.ContatoTrabalho;
import br.com.uece.peoo.util.Question;
import br.com.uece.peoo.util.TipoContato;

/**
 * Crie uma classe Pessoa contendo nome e telefone. Crie um construtor e métodos de acesso aos atributos. 
 * Crie um método para mostrar os dados de uma pessoa Crie uma classe Agenda que possui uma lista de pessoas. 
 * Implemente métodos para adicionar (se já existir, sugerir substituir), procurar (pelo nome ou pelo telefone), 
 * alterar telefone e remover pessoas. Crie também um método para mostrar todas as pessoas da lista. 
 * Crie uma classe Principal para exercitar sua Agenda
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Question05_01 extends Question{

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Adicionando pessoas");
		// nao existem mais contatos genericos
		agenda.addContato(new ContatoInfancia("Ericson Rogerio Moreira", "(85) 99792-6510", 32));
		agenda.addContato(new ContatoInfancia("Christina J. Pelkey", "(11) 2418-6344", 25));
		agenda.addContato(new ContatoInfancia("Donna J. Tapia", "(75) 2000-2662", 20));
		agenda.addContato(new ContatoInfancia("Edna J. Jones", "(16) 6094-6352", 40));
		agenda.addContato(new ContatoTrabalho("James C. Childress", "(11) 6208-9848", "TI"));
		agenda.addContato(new ContatoTrabalho("Amber D. Bosch", "(11) 6888-2177", "TI"));

		// Mostranto todas as pessoas
		agenda.showContatosPorTipo(TipoContato.TODOS);

		System.out.println("Procurando pessoas pelo Fone");

		System.out.println(agenda.procuraContatoPorTelefone("(85) 99792-6510"));
		System.out.println(agenda.procuraContatoPorTelefone("(16) 6094-6352"));
		System.out.println(agenda.procuraContatoPorTelefone("(88) 99792-6510"));

		System.out.println("Auterar as o telefone das pessoas");	

		agenda.mudaTelefoneDoContato("Donna J. Tapia", "(75) 2000-0000");
		agenda.mudaTelefoneDoContato("Edna J. Jones", "(16) 6094-0000");
		agenda.mudaTelefoneDoContato("James C. Childress", "(11) 6208-0000");
		agenda.mudaTelefoneDoContato("Amber C. Bosch", "(11) 6888-2177"); // O nome dessa pessoa está errado.

		agenda.showContatosPorTipo(TipoContato.TODOS);
		
		System.out.println("Remover pessoas");
		
		agenda.removerContato("Ericson Rogerio Moreira");
		agenda.removerContato("Amber D. Bosch");
		agenda.removerContato("Amber C. Bosch"); // O nome dessa pessoa está errado.

		agenda.showContatosPorTipo(TipoContato.TODOS);

	}

}
