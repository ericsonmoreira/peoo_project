package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Agenda;

/**
 * Incremente o exercício da Agenda a partir da seguinte especificação:
 *
 * Um Contato pode ser um amigo de trabalho ou amigo de infância. Se o for um contato de trabalho, deve-se armazenar o
 * setor onde trabalha (informática, rh, finanças...). Se for contato de infância, armazenar a idade. Lembre que a
 * classe Contato tem o método mostrar dados, que mostra nome e telefone. Sobrescreva esse método nas classes
 * ContatoTrabalho e ContatoInfancia para mostrar também os dados específicos de cada um.
 * Refaça a classe Agenda para que ela tenha agora três listas: uma de contatos, outra de contatos de trabalho e outra
 * de contatos de infância. Faça os métodos para adicionar contato de trabalho e adicionar contato de infância.
 * Faça também um método para mostrar os dados de todos os contatos. Esse método recebe como parâmetro o tipo de
 * contato desejado (geral, trabalho, infância, ou todos). Faça também um método que mostre os contatos de trabalho
 * passando como parâmetro o setor de trabalho, ou seja, ele retornará os dados de todos os contatos do que trabalham
 * no setor passado como parâmetro.
 */
public class Question07_02 {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        System.out.println("Adicionando Contatos");

        // Contatos de Trabalho
        agenda.addContatoTrabalho("Ericson Rogerio Moreira", "(85) 99792-6510", "TI");
        agenda.addContatoTrabalho("Christina J. Pelkey", "(11) 2418-6344", "TI");
        agenda.addContatoTrabalho("Donna J. Tapia", "(75) 2000-2662", "RH");
        agenda.addContatoTrabalho("Edna J. Jones", "(16) 6094-6352", "RH");
        agenda.addContatoTrabalho("James C. Childress", "(11) 6208-9848", "RH");
        agenda.addContatoTrabalho("Amber D. Bosch", "(11) 6888-2177", "ADM");

        // Contatos de Infância
        agenda.addContatoInfancia("Ericson Rogerio Moreira", "(85) 99792-6510", 32);
        agenda.addContatoInfancia("Christina J. Pelkey", "(11) 2418-6344", 20);
        agenda.addContatoInfancia("Donna J. Tapia", "(75) 2000-2662", 29);
        agenda.addContatoInfancia("Edna J. Jones", "(16) 6094-6352", 34);
        agenda.addContatoInfancia("James C. Childress", "(11) 6208-9848", 56);
        agenda.addContatoInfancia("Amber D. Bosch", "(11) 6888-2177",21);

        // Mostranto todas as pessoas
        agenda.showTodosContatos();

        System.out.println("Procurando pessoas pelo Fone");

        System.out.println(agenda.procuraContatoPorTelefone("(85) 99792-6510"));
        System.out.println(agenda.procuraContatoPorTelefone("(16) 6094-6352"));
        System.out.println(agenda.procuraContatoPorTelefone("(88) 99792-6510"));

        System.out.println("Auterar as o telefone das pessoas");

        agenda.mudaTelefoneDoContato("Donna J. Tapia", "(75) 2000-0000");
        agenda.mudaTelefoneDoContato("Edna J. Jones", "(16) 6094-0000");
        agenda.mudaTelefoneDoContato("James C. Childress", "(11) 6208-0000");
        agenda.mudaTelefoneDoContato("Amber C. Bosch", "(11) 6888-2177"); // O nome dessa pessoa está errado.

        agenda.showTodosContatos();

        System.out.println("Remover pessoas");

        agenda.removerContato("Ericson Rogerio Moreira");
        agenda.removerContato("Amber D. Bosch");
        agenda.removerContato("Amber C. Bosch"); // O nome dessa pessoa está errado.

        agenda.showTodosContatos();

        System.out.println("Todos contatos de trabalho do setor de TI");
        agenda.showContatosPorSetorDeTrabalho("TI");
    }
}
