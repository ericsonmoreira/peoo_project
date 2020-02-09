package lesson_05.questions;

import model.Banco;
import model.Conta;
import util.Question;

import java.util.Scanner;

/**
 * Crie uma classe Banco que possui como atributos um nome e um vetor de contas. Faça um construtor
 * que recebe o nome do banco e a quantidade de elementos no vetor, e inicialize os atributos.
 * Faça também métodos de procurar uma conta (passando como parâmetro o número da conta), cadastrar
 * uma nova conta e transferir dinheiro entre contas.
 * <p>
 * Crie uma classe Principal que instancie um banco e forneça ao usuário um menu para ele criar contas,
 * sacar, depositar e alterar dados.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question_01 extends Question {

    // Define um Banco.
    private static Banco banco = new Banco("BB");

    /**
     * Cria um Loop Infinito para chamar as opções que forem sendo escolhidas.
     */
    private static void menu() {
        // Loop infinito.
        while (true) {
            int opition = printMenu();
            switch (opition) {
                case 1: // Criar contra.
                    criarConta();
                    break;
                case 2: // Sacar.
                    sacarDeUmaConta();
                    break;
                case 3: // Depositar.
                    depositarEmUmaConta();
                    break;
                case 4: // Alterar dados.
                    alterarConta();
                    break;
                case 5: // Transferência entre contas.
                    transferirEntreContas();
                    break;
                case 6: // Listar contas.
                    listarContas();
                    break;
                case 7: // Encerrar conta.
                    removerConta();
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
    private static void transferirEntreContas() {
        // Procura o Devedor.
        // ToDo: Aprender mais sobre "Para de retornar null e comece a usar OPTIONAL"
        System.out.println("Digite o número da Conta Devedora:");
        Conta debtor = banco.buscarConta(scanner.nextInt());
        if (debtor == null) {
            System.out.println("Essa contra não existe!");
            return;
        }
        // Procura o Credor.
        System.out.println("Digite o número da Conta Credota:");
        Conta creditor = banco.buscarConta(scanner.nextInt());
        if (creditor == null) {
            System.out.println("Essa contra não existe!");
            return;
        }
        // Valor a ser Transferido.
        System.out.println("Digite o Valor a ser Transferido:");
        double value = scanner.nextDouble();

        if (banco.transferir(debtor, creditor, value)) {
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência não realizada.");
        }
    }

    /**
     *
     */
    private static void removerConta() {
        System.out.println("Digite o número da Conta:");
        int num = scanner.nextInt();
        Conta out = banco.buscarConta(num);
        if (out != null) {
            System.out.println("Encerrando Conta.");
            banco.removerConta(num);
        } else {
            System.out.println("Não existe conta com num " + num + " cadastrada.");
        }
    }

    /**
     * Muda uma conta selecionada pelo número da conta.
     */
    private static void alterarConta() {
        System.out.println("Digite o número da Conta:");
        int num = scanner.nextInt();
        Conta out = banco.buscarConta(num);
        if (out != null) {
            System.out.println("Atualize o titular da conta:");
            out.setTitular(scanner.next());
            System.out.println("Atualize o saldo da conta:");
            out.setSaldo(scanner.nextDouble());
            System.out.println(out);
        } else {
            System.out.println("Não existe conta com num " + num + " cadastrada.");
        }
    }

    /**
     * Faz um depósito na conta escolhida.
     */
    private static void depositarEmUmaConta() {
        System.out.println("Digite o número da Conta:");
        int num = scanner.nextInt();
        Conta out = banco.buscarConta(num);
        if (out != null) {
            System.out.println("Digite o Valor do deposito:");
            double value = scanner.nextDouble();
            System.out.println(out);
            out.depositar(value);
        } else {
            System.out.println("Não existe conta com num " + num + " cadastrada.");
        }
    }

    /**
     * Sacar fa conta escolhida.
     */
    private static void sacarDeUmaConta() {
        System.out.println("Digite o número da Conta:");
        int num = scanner.nextInt();
        Conta out = banco.buscarConta(num);
        if (out != null) {
            System.out.println("Digite o Valor do saque:");
            double value = scanner.nextDouble();
            System.out.println(out);
            out.sacar(value);
        } else {
            System.out.println("Não existe conta com num " + num + " cadastrada.");
        }
    }

    /**
     * Listar todas as contras do banco mostrando no Console.
     */
    private static void listarContas() {
        if (!banco.getContas().isEmpty()) {
            banco.getContas().forEach(System.out::println);
        } else {
            System.out.println("Nenhuma conta cadastrada.");
        }
    }

    /**
     * Criar uma nova conta.
     */
    private static void criarConta() {
        System.out.println("Digite o Número da Conta:");
        int numAccount = scanner.nextInt();
        System.out.println("Digite o Nome do Titular da Conta:");
        // Não entendo pq o scanner normal estava dando problema aqui como nextLine().
        @SuppressWarnings("resource")
        String holder = new Scanner(System.in).nextLine();
        System.out.println("Digite o Saldo da Conta:");
        double balance = scanner.nextDouble();
        Conta account = new Conta(numAccount, holder, balance);
        banco.addConta(account);
    }

    /**
     * Imprime as opições para o Usuário.
     * <p>
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
