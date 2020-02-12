package lesson_08.questions;

import model.Banco;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

/**
 * Exercício: Refazer o exercício do Banco para que ele contenha uma lista de contas, contas corrente e contas
 * poupanças.
 *
 * Insira e mostra os dados de todas as contas.
 *
 * Obs.: Nesse enunciado, o professor não deixou claro se ele quer mais de uma lista. Porém, como se trata
 * de uma aula de polimorfismo, vou considerar que ele se referia a uma única lista de contas. Vou usar como
 * lista única a lista genéria de contas da classe Banco.
 */
public class Question_03 {
    public static void main(String[] args) {

        // Instanciando um banco.
        Banco banco = new Banco("Banco PEOO");

        // Instanciando contas genéricas.
        banco.addConta(new Conta(1, "Kauê Cunha Pinto", 100));
        banco.addConta(new Conta(2, "Julian Barbosa Rodrigues", 100));
        banco.addConta(new Conta(3, "Aline Souza Gomes", 100));
        banco.addConta(new Conta(4, "Giovana Rodrigues Castro", 100));
        banco.addConta(new Conta(5, "Rodrigo Souza Alves", 100));
        banco.addConta(new Conta(6, "Nicole Almeida Dias", 100));
        banco.addConta(new Conta(7, "Murilo Carvalho Pereira", 100));

        // Instanciando contas corrêntes.
        banco.addConta(new ContaCorrente(8, "Clara Santos Cunha", 100, 100));
        banco.addConta(new ContaCorrente(9, "Mariana Correia Barbosa", 100, 100));
        banco.addConta(new ContaCorrente(10, "Isabela Martins Cardoso", 100, 100));
        banco.addConta(new ContaCorrente(11, "Brenda Souza Goncalves", 100, 100));
        banco.addConta(new ContaCorrente(12, "Bruna Costa Cunha", 100, 100));
        banco.addConta(new ContaCorrente(13, "Arthur Ferreira Cunha", 100, 100));
        banco.addConta(new ContaCorrente(14, "Brenda Rodrigues Goncalves", 100, 100));
        banco.addConta(new ContaCorrente(15, "Luiz Silva Souza", 100, 100));
        banco.addConta(new ContaCorrente(16, "Gabrielly Dias Oliveira", 100, 100));

        // Instanciando contas poupança.
        banco.addConta(new ContaPoupanca(17, "Erick Melo Lima", 100, 0.05));
        banco.addConta(new ContaPoupanca(18, "Rodrigo Almeida Santos", 100, 0.05));
        banco.addConta(new ContaPoupanca(19, "Rafael Cunha Sousa", 100, 0.05));
        banco.addConta(new ContaPoupanca(20, "Camila Fernandes Silva", 100, 0.05));
        banco.addConta(new ContaPoupanca(21, "Luiz Sousa Cardoso", 100, 0.05));
        banco.addConta(new ContaPoupanca(22, "Gabrielly Almeida Barbosa", 100, 0.05));

        // Imprimindo todas as contas.
        System.out.println("Todas as contas:");
        banco.showContas();

        // Mostrando o Relatório das Contas do banco.
        banco.relatorioContas();

    }
}
