package lesson_05.questions;

import util.Banck;
import util.BankAccount;
import util.Question;

/**
 * 
 * Crie uma classe Banco que possui como atributos um nome e um vetor de contas. Faça um construtor 
 * que recebe o nome do banco e a quantidade de elementos no vetor, e inicialize os atributos. 
 * Faça também métodos de procurar uma conta (passando como parâmetro o número da conta), cadastrar 
 * uma nova conta e transferir dinheiro entre contas. 
 * 
 * Crie uma classe Principal que instancie um banco e forneça ao usuário um menu para ele criar contas, 
 * sacar, depositar e alterar dados.
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class Question_01 extends Question {

	private static Banck banck = new Banck("BB");
	
	private static void menu() {
		// Loop infinito.
		while (true) {
			int opition = printMenu();
			switch (opition) {
			case 1: // Criar contra.
				createAccount();
				break;
			case 2: // Sacar.
				withdrawForAccount();
				break;
			case 3: // Depositar.
				depositForAccount();
				break;
			case 4: // Alterar dados.
				changeAccount();
				break;
			case 5: // Listar contas.
				listAcconts();
				break;
			case 6: // Sair do Sistema.
				System.out.println("Saindo do Sistema. Obrigado pela preferência!");
				System.exit(0);
			default:
				System.err.println("Opção Invalida!");
			}
		}
	}

	/**
	 * 
	 */
	private static void changeAccount() {
		System.out.println("Digite o número da Conta:");
		int num = scanner.nextInt();
		BankAccount out = banck.findAccount(num);
		if (out != null) {
			System.out.println("Atualize o titular da conta:");
			out.setHolder(scanner.next());
			System.out.println("Atualize o saldo da conta:");
			out.setBalance(scanner.nextDouble());
			System.out.println(out);
		} else {
			System.out.println("Não existe conta com num " + num + " cadastrada.");
		}
	}

	/**
	 * 
	 */
	private static void depositForAccount() {
		System.out.println("Digite o número da Conta:");
		int num = scanner.nextInt();
		BankAccount out = banck.findAccount(num);
		if (out != null) {
			System.out.println("Digite o Valor do deposito:");
			double value = scanner.nextDouble();
			System.out.println(out);
			out.deposit(value);
		} else {
			System.out.println("Não existe conta com num " + num + " cadastrada.");
		}
	}

	/**
	 * 
	 */
	private static void withdrawForAccount() {
		System.out.println("Digite o número da Conta:");
		int num = scanner.nextInt();
		BankAccount out = banck.findAccount(num);
		if (out != null) {
			System.out.println("Digite o Valor do saque:");
			double value = scanner.nextDouble();
			System.out.println(out);
			out.withdraw(value);
		} else {
			System.out.println("Não existe conta com num " + num + " cadastrada.");
		}
	}

	private static void listAcconts() {
		if (!banck.getAccounts().isEmpty()) {
			for (BankAccount bankAccount : banck.getAccounts()) {
				System.out.println(bankAccount);					}
		} else {
			System.out.println("Nenhuma conta cadastrada.");
		}
	}

	private static void createAccount() {
		System.out.println("Digite o Número da Conta:");
		int numAccount = scanner.nextInt();
		System.out.println("Digite o Nome do Titular da Conta:");
		String holder = scanner.next();
		System.out.println("Digite o Saldo da Conta:");
		double balance = scanner.nextDouble();
		BankAccount account = new BankAccount(numAccount, holder, balance);
		banck.addAccount(account);
	}

	/**
	 * Imprime as opções.
	 * 1) Criar conta.
	 * 2) Sacar
	 * 3) Depositar
	 * 4) Alterar dados
	 * 5) Listar contas.
	 * 5) Fechar programa.
	 * 
	 */
	private static int printMenu() {
		System.out.println("------------------- Menu ---------------------");
		System.out.println("1 --> Criar uma Conta.");
		System.out.println("2 --> Sacar.");
		System.out.println("3 --> Depositar.");
		System.out.println("4 --> Alterar dados.");
		System.out.println("5 --> Listar contas.");
		System.out.println("6 --> Fechar programa.");
		System.out.println("Digite a opção: ");
		int opition = scanner.nextInt();
		return opition;
	}

	public static void main(String[] args) {
		
		menu();

	}

}
