package lesson_05.questions;

import java.util.Scanner;

import util.Bank;
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
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Question_01 extends Question {

	// Define um Banco.
	private static Bank bank = new Bank("BB");
	
	/**
	 * Cria um Loop Infinito para chamar as opções que forem sendo escolhidas.
	 */
	private static void menu() {
		// Loop infinito.
		while (true) {
			int opition = printMenu();
			switch (opition) {
			case 1: // Criar contra.
				createAccount();
				break;
			case 2: // Sacar.
				withdrawInAccount();
				break;
			case 3: // Depositar.
				depositInAccount();
				break;
			case 4: // Alterar dados.
				changeAccount();
				break;
			case 5: // Transferência entre contas.
				transferBetweenAccount();
				break;
			case 6: // Listar contas.
				listAccounts();
				break;
			case 7: // Encerrar conta.
				removeAccount();
				break;
			case 8: // Fechar programa
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
	private static void transferBetweenAccount() {
		// Procura o Devedor. 
		System.out.println("Digite o número da Conta Devedora:");
		BankAccount debtor = bank.findAccount(scanner.nextInt());
		if (debtor == null) {
			System.out.println("Essa contra não existe!");
			return;
		}
		// Procura o Credor.
		System.out.println("Digite o número da Conta Credota:");
		BankAccount creditor = bank.findAccount(scanner.nextInt());
		if (creditor == null) {
			System.out.println("Essa contra não existe!");
			return;
		}
		// Valor a ser Transferido.
		System.out.println("Digite o Valor a ser Transferido:");
		double value = scanner.nextDouble();
		
		if (bank.transfer(debtor, creditor, value)) {
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Transferência não realizada.");
		}
	}

	/**
	 * 
	 */
	private static void removeAccount() {
		System.out.println("Digite o número da Conta:");
		int num = scanner.nextInt();
		BankAccount out = bank.findAccount(num);
		if (out != null) {
			System.out.println("Encerrando Conta.");
			bank.removeAccont(num);
		} else {
			System.out.println("Não existe conta com num " + num + " cadastrada.");
		}
	}

	/**
	 * Muda uma conta selecionada pelo número da conta.
	 */
	private static void changeAccount() {
		System.out.println("Digite o número da Conta:");
		int num = scanner.nextInt();
		BankAccount out = bank.findAccount(num);
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
	 * Faz um depósito na conta escolhida.
	 */
	private static void depositInAccount() {
		System.out.println("Digite o número da Conta:");
		int num = scanner.nextInt();
		BankAccount out = bank.findAccount(num);
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
	 * Sacar fa conta escolhida.
	 */
	private static void withdrawInAccount() {
		System.out.println("Digite o número da Conta:");
		int num = scanner.nextInt();
		BankAccount out = bank.findAccount(num);
		if (out != null) {
			System.out.println("Digite o Valor do saque:");
			double value = scanner.nextDouble();
			System.out.println(out);
			out.withdraw(value);
		} else {
			System.out.println("Não existe conta com num " + num + " cadastrada.");
		}
	}

	/**
	 * Listar todas as contras do banco mostrando no Console.
	 */
	private static void listAccounts() {
		if (!bank.getAccounts().isEmpty()) {
			for (BankAccount bankAccount : bank.getAccounts()) {
				System.out.println(bankAccount);					}
		} else {
			System.out.println("Nenhuma conta cadastrada.");
		}
	}

	/**
	 * Criar uma nova conta.
	 */
	private static void createAccount() {
		System.out.println("Digite o Número da Conta:");
		int numAccount = scanner.nextInt();
		System.out.println("Digite o Nome do Titular da Conta:");
		// Não entendo pq o scanner normal estava dando problema aqui como nextLine().
		@SuppressWarnings("resource")
		String holder = new Scanner(System.in).nextLine();
		System.out.println("Digite o Saldo da Conta:");
		double balance = scanner.nextDouble();
		BankAccount account = new BankAccount(numAccount, holder, balance);
		bank.addAccount(account);
	}

	/**
	 * Imprime as opições para o Usuário. 
	 * 
	 * Imprime as opções.
	 * 1) Criar conta.
	 * 2) Sacar
	 * 3) Depositar
	 * 4) Alterar dados
	 * 5) Transferência entre contas.
	 * 6) Listar contas.
	 * 7) Encerrar conta.
	 * 8) Fechar programa.
	 * 
	 * @return Valor da opção digitada.
	 */
	private static int printMenu() {
		System.out.println("------------------- Menu ---------------------");
		System.out.println("1 --> Criar uma Conta.");
		System.out.println("2 --> Sacar.");
		System.out.println("3 --> Depositar.");
		System.out.println("4 --> Alterar dados.");
		System.out.println("5 --> Transferência entre contas.");
		System.out.println("6 --> Listar contas.");
		System.out.println("7 --> Encerrar conta.");
		System.out.println("8 --> Fechar Programa.");
		System.out.println("Digite a opção: ");
		return scanner.nextInt(); // Retorna a opção digitada.
	}

	public static void main(String[] args) {
		
		// Iniciação do Menu de opições.
		menu();

	}

}
