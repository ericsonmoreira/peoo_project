package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Banco;
import br.com.uece.peoo.model.Conta;
import br.com.uece.peoo.util.Menu;
import br.com.uece.peoo.util.Question;

import java.util.Optional;
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
public class Question04_01 extends Question {

    // Define um Banco.
    private static Banco banco = new Banco("BB");

    private static Menu menu;

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

    private static void listarContas() {
        if (!banco.getContas().isEmpty()) {
            banco.getContas().forEach(System.out::println);
        } else {
            System.out.println("Nenhuma conta cadastrada.");
        }
    }

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

    public static void init(){
        menu = new Menu();
        menu.addOption(1, "Criar uma Conta.", () -> criarConta());
        menu.addOption(2, "Sacar.", () -> sacarDeUmaConta());
        menu.addOption(3, "Depositar.", () -> depositarEmUmaConta());
        menu.addOption(4, "Alterar dados.", () -> alterarConta());
        menu.addOption(5, "Transferência entre contas.", () -> transferirEntreContas());
        menu.addOption(6, "Listar contas.", () -> listarContas());
        menu.addOption(7, "Encerrar conta.", () -> removerConta());
        menu.addOption(99, "Fechar Programa.", () -> fecharPrograma());
    }
}
