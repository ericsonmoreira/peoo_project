package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Agenda;
import br.com.uece.peoo.util.Menu;
import br.com.uece.peoo.util.Question;
import br.com.uece.peoo.util.TipoContato;

import java.util.Optional;
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
public class Question05_02 extends Question{

	public static Agenda agenda;

	private static Menu menu;

	private static void showTodasMensagens() {
		agenda.getMensagens().forEach(message -> System.out.println(message));
	}

	private static void showTotalDeMensagens() {
		System.out.println("Total de mensagnes enviadas: " + agenda.getMensagens().size() + ".");
	}

	private static void showTotasMesagensPorContato() {
		System.out.println("Digite o nome do contato: ");
		// Não sei pq precisa disso.
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);
		String contactName = input.nextLine();
		agenda.getMensagens().forEach(message -> System.out.print(
				message.getContato().getNome().equals(contactName) ? message + "\n": ""));
	}


	public static void main(String[] args) {
		init(); // INICIALIZANDO

		Scanner scanner = new Scanner(System.in);

		while (true) { // Loop infinito.
			menu.printMenu();
			System.out.println("Digite uma opição:");
			int opition = scanner.nextInt();
			Optional<Runnable> runnable = Optional.ofNullable(menu.getRunnable(opition));
			runnable.ifPresentOrElse(Runnable::run, () -> System.err.println("Opção Invalida!"));
		}
	}

	private static void init() {
		agenda = new Agenda();
		agenda.addContato("Ericson Rogerio Moreira", "(85) 99792-6510");
		agenda.addContato("Christina J. Pelkey", "(11) 2418-6344");
		agenda.addContato("Donna J. Tapia", "(75) 2000-2662");
		agenda.addContato("Edna J. Jones", "(16) 6094-6352");
		agenda.addContato("James C. Childress", "(11) 6208-9848");
		agenda.addContato("Amber D. Bosch", "(11) 6888-2177");

		agenda.showContatosPorTipo(TipoContato.TODOS);

		agenda.enviaMessage("(85) 99792-6510", "Olá, tudo bem?");
		agenda.enviaMessage("(85) 99792-6510", "Comigo também.");
		agenda.enviaMessage("(85) 99792-6510", "Como vai a família?");
		agenda.enviaMessage("(11) 2418-6344", "Ainda não consegi aquele cliente.");
		agenda.enviaMessage("(11) 2418-6344", "Ele está muito receioso para contratar o seguro. Mas eu não vou desistir.");
		agenda.enviaMessage("(11) 2418-6344", "Consegui a venda!");
		agenda.enviaMessage("(11) 2418-6344", "Meta batida.");
		agenda.enviaMessage("(11) 2418-6344", "Agora posso entrar de férias.");

		// Iniciando Menu.
		menu = new Menu();
		menu.addOption(1, "Todas as mensagens.", () -> showTodasMensagens());
		menu.addOption(2, "Mensagens de para um contato.", () -> showTotasMesagensPorContato());
		menu.addOption(3, "Total de mensagens.", () -> showTotalDeMensagens());
		menu.addOption(99, "Fechar Programa.", () -> fecharPrograma());
	}
}
