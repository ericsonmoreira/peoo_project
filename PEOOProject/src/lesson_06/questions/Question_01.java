package lesson_06.questions;

import model.Agenda;
import util.Question;

/**
 * Crie uma classe Pessoa contendo nome e telefone. Crie um construtor e métodos de acesso aos atributos.
 * Crie um método para mostrar os dados de uma pessoa Crie uma classe Agenda que possui uma lista de pessoas.
 * Implemente métodos para adicionar (se já existir, sugerir substituir), procurar (pelo nome ou pelo telefone),
 * alterar telefone e remover pessoas. Crie também um método para mostrar todas as pessoas da lista.
 * Crie uma classe Principal para exercitar sua Agenda
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question_01 extends Question {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        System.out.println("Adicionando Contatos");

        agenda.addContato("Ericson Rogerio Moreira", "(85) 99792-6510");
        agenda.addContato("Christina J. Pelkey", "(11) 2418-6344");
        agenda.addContato("Donna J. Tapia", "(75) 2000-2662");
        agenda.addContato("Edna J. Jones", "(16) 6094-6352");
        agenda.addContato("James C. Childress", "(11) 6208-9848");
        agenda.addContato("Amber D. Bosch", "(11) 6888-2177");

        // Mostranto todas as pessoas
        agenda.showTodosContatosGeral();

        System.out.println("Procurando pessoas pelo Fone");

        System.out.println(agenda.findContatoPorFone("(85) 99792-6510"));
        System.out.println(agenda.findContatoPorFone("(16) 6094-6352"));
        System.out.println(agenda.findContatoPorFone("(88) 99792-6510"));

        System.out.println("Auterar as o telefone das pessoas");

        agenda.changeFonePessoa("Donna J. Tapia", "(75) 2000-0000");
        agenda.changeFonePessoa("Edna J. Jones", "(16) 6094-0000");
        agenda.changeFonePessoa("James C. Childress", "(11) 6208-0000");
        agenda.changeFonePessoa("Amber C. Bosch", "(11) 6888-2177"); // O nome dessa pessoa está errado.

        agenda.showTodosContatosGeral();

        System.out.println("Remover pessoas");

        agenda.removeContato("Ericson Rogerio Moreira");
        agenda.removeContato("Amber D. Bosch");
        agenda.removeContato("Amber C. Bosch"); // O nome dessa pessoa está errado.

        agenda.showTodosContatosGeral();

    }

}
