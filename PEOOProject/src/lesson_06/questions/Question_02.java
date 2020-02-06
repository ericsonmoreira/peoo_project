package lesson_06.questions;

import model.Agenda;
import util.Question;
import util.TipoContato;

import java.util.Scanner;

/**
 * Incremente sua Agenda para permitir que você possa enviar uma mensagem de texto a um contato. 
 * Todas as mensagens devem ser armazenadas na agenda. Para tanto, crie a classe Mensagem, que possui 
 * como atributos o contato para o qual a mensagem foi enviada, o texto da mensagem, e a data de envio. 
 * Passe os dois primeiros parâmetros no construtor da mensagem, enquanto a data é criada automaticamente. 
 * Crie também um método para mostrar o nome do destinatário, a mensagem e a hora de envio. Na classe 
 * Agenda, crie uma lista de mensagens e um método enviarMensagem, que recebe o número do contato e a 
 * mensagem a ser enviada, e realiza o envio. Disponibilize no seu menu principal opções para visualizar 
 * todas as mensagens enviadas ou apenas as enviadas para um determinado contato, mostrando também a 
 * quantidade de mensagens enviadas.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Question_02 extends Question{


	public static Agenda schedule;
	/**
	 * Cria um Loop Infinito para chamar as opções que forem sendo escolhidas.
	 */
	private static void menu() {
		// Loop infinito.
		while (true) {
			int opition = printMenu();
			switch (opition) {
			case 1: // Mostrar todas as mensagens.
				showAllMessages();
				break;
			case 2: // Mostrar todas as mensagens enviadas para um certo contato.
				showAllMessagesForContact();
				break;
			case 3: // Mostar o total de mensagens.
				showCountMessages();
				break;
			case 4: // Fechar programa
				System.out.println("Saindo do Sistema.");
				System.exit(0);
			default:
				System.err.println("Opção Invalida!");
			}
		}

	}

	private static void showAllMessages() {
		schedule.getMessages().forEach(message -> System.out.println(message));
	}

	private static void showCountMessages() {
		System.out.println("Total de mensagnes enviadas: " + schedule.getMessages().size() + ".");
	}

	private static void showAllMessagesForContact() {
		System.out.println("Digite o nome do contato: ");
		// Não sei pq precisa disso.
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);
		String contactName = input.nextLine();
		schedule.getMessages().forEach(message -> System.out.print(
				message.getContato().getName().equals(contactName) ? message + "\n": ""));
	}

	/**
	 * Imprime as opições para o Usuário. 
	 * 
	 * Imprime as opções.
	 * 1) Todas as mensagens
	 * 2) Mensagens de para um contato
	 * 3) Total de mensagens
	 * 4) Fechar programa.
	 * 
	 * @return Valor da opção digitada.
	 */
	private static int printMenu() {
		System.out.println("------------------- Menu ---------------------");
		System.out.println("1 --> Todas as mensagens.");
		System.out.println("2 --> Mensagens de para um contato.");
		System.out.println("3 --> Total de mensagens.");
		System.out.println("4 --> Fechar Programa.");
		System.out.println("Digite a opção: ");
		int option = scanner.nextInt();
		return option; // Retorna a opção digitada.
	}
	public static void main(String[] args) {
		// Iniciando com alguns valores.
		init();
		
		// Chamando o menu.
		menu();
	}

	private static void init() {
		schedule = new Agenda();
		schedule.addContato("Ericson Rogerio Moreira", "(85) 99792-6510");
		schedule.addContato("Christina J. Pelkey", "(11) 2418-6344");
		schedule.addContato("Donna J. Tapia", "(75) 2000-2662");
		schedule.addContato("Edna J. Jones", "(16) 6094-6352");
		schedule.addContato("James C. Childress", "(11) 6208-9848");
		schedule.addContato("Amber D. Bosch", "(11) 6888-2177");
		
		schedule.showContatosPorTipo(TipoContato.TODOS);
		
		schedule.sendMessage("(85) 99792-6510", "Olá, tudo bem?");
		schedule.sendMessage("(85) 99792-6510", "Comigo também.");
		schedule.sendMessage("(85) 99792-6510", "Como vai a família?");
		schedule.sendMessage("(11) 2418-6344", "Ainda não consegi aquele cliente.");
		schedule.sendMessage("(11) 2418-6344", "Ele está muito receioso para contratar o seguro. Mas eu não vou desistir.");
		schedule.sendMessage("(11) 2418-6344", "Consegui a venda!");
		schedule.sendMessage("(11) 2418-6344", "Meta batida.");
		schedule.sendMessage("(11) 2418-6344", "Agora posso entrar de férias.");
		
	}

}
