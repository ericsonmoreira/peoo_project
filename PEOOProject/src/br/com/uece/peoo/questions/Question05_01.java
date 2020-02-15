package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Agenda;
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
		Agenda schedule = new Agenda();

		System.out.println("Adicionando pessoas");
		
		schedule.addContato("Ericson Rogerio Moreira", "(85) 99792-6510");
		schedule.addContato("Christina J. Pelkey", "(11) 2418-6344");
		schedule.addContato("Donna J. Tapia", "(75) 2000-2662");
		schedule.addContato("Edna J. Jones", "(16) 6094-6352");
		schedule.addContato("James C. Childress", "(11) 6208-9848");
		schedule.addContato("Amber D. Bosch", "(11) 6888-2177");

		// Mostranto todas as pessoas
		schedule.showContatosPorTipo(TipoContato.TODOS);

		System.out.println("Procurando pessoas pelo Fone");

		System.out.println(schedule.procuraContatoPorTelefone("(85) 99792-6510"));
		System.out.println(schedule.procuraContatoPorTelefone("(16) 6094-6352"));
		System.out.println(schedule.procuraContatoPorTelefone("(88) 99792-6510"));

		System.out.println("Auterar as o telefone das pessoas");	

		schedule.mudaTelefoneDoContato("Donna J. Tapia", "(75) 2000-0000");
		schedule.mudaTelefoneDoContato("Edna J. Jones", "(16) 6094-0000");
		schedule.mudaTelefoneDoContato("James C. Childress", "(11) 6208-0000");
		schedule.mudaTelefoneDoContato("Amber C. Bosch", "(11) 6888-2177"); // O nome dessa pessoa está errado.

		schedule.showContatosPorTipo(TipoContato.TODOS);
		
		System.out.println("Remover pessoas");
		
		schedule.removerContato("Ericson Rogerio Moreira");
		schedule.removerContato("Amber D. Bosch");
		schedule.removerContato("Amber C. Bosch"); // O nome dessa pessoa está errado.

		schedule.showContatosPorTipo(TipoContato.TODOS);

	}

}