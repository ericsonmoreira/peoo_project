package lesson_06.questions;

import model.Schedule;
import util.Question;

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
public class Question_01 extends Question{

	public static void main(String[] args) {
		Schedule schedule = new Schedule();

		System.out.println("Adicionando pessoas");
		
		schedule.addPessoa("Ericson Rogerio Moreira", "(85) 99792-6510");
		schedule.addPessoa("Christina J. Pelkey", "(11) 2418-6344");
		schedule.addPessoa("Donna J. Tapia", "(75) 2000-2662");
		schedule.addPessoa("Edna J. Jones", "(16) 6094-6352");
		schedule.addPessoa("James C. Childress", "(11) 6208-9848");
		schedule.addPessoa("Amber D. Bosch", "(11) 6888-2177");

		// Mostranto todas as pessoas
		schedule.showAllPessoas();

		System.out.println("Procurando pessoas pelo Fone");

		System.out.println(schedule.findPessoaForFone("(85) 99792-6510"));
		System.out.println(schedule.findPessoaForFone("(16) 6094-6352"));
		System.out.println(schedule.findPessoaForFone("(88) 99792-6510"));

		System.out.println("Auterar as o telefone das pessoas");	

		schedule.changeFonePessoa("Donna J. Tapia", "(75) 2000-0000");
		schedule.changeFonePessoa("Edna J. Jones", "(16) 6094-0000");
		schedule.changeFonePessoa("James C. Childress", "(11) 6208-0000");
		schedule.changeFonePessoa("Amber C. Bosch", "(11) 6888-2177"); // O nome dessa pessoa está errado.

		schedule.showAllPessoas();
		
		System.out.println("Remover pessoas");
		
		schedule.removePessoa("Ericson Rogerio Moreira");
		schedule.removePessoa("Amber D. Bosch");
		schedule.removePessoa("Amber C. Bosch"); // O nome dessa pessoa está errado.
		
		schedule.showAllPessoas();

	}

}
