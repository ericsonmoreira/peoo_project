package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.*;

/**
 * Exercício Herança e Polimorfismo
 *
 * Uma universidade possui um registro de seus funcionários armazenando a matrícula e nome de cada um. Por padrão, o
 * salário de um funcionário é o valor do salário mínimo (considere o valor de R$1000 para facilitar). Na universidade
 * trabalham professores, secretários e servidores. Funcionários tem os métodos imprimirDados() e calcularSalario().
 *
 * O salário dos professores depende da titulação e da sua carga horária. Para os mestres, o valor da hora/aula é R$80,
 * enquanto o doutor ganha R$100 por hora/aula. Além disso, caso o professor seja coordenador, ele pode tem uma
 * gratificação de 20% do valor final de seu salário.
 *
 * Secretários trabalham 20, 30 ou 40 horas semanais. Seu salário é a calculado pelo valor da hora de trabalho, que é de
 * R$8 para quem trabalha até 30h/semana e R$10 para quem trabalha 40h/semana, vezes a quantidade de horas mensais
 * trabalhadas (considere um mês como tendo 4 semanas).
 *
 * Técnicos podem trabalhar horas extras, cujo valor unitário é de R$15. Seu salário final é a soma do salário de um
 * funcionário mais o total ganho com horas extras.
 *
 * Essa universidade possui um nome e uma lista de funcionários. Crie um método para adicionar funcionários na lista e
 * outro para gerar a folha de pagamento desta universidade, mostrando os dados e salário final de todos os
 * funcionários, além do valor total pago pela universidade. Faça um programa que implemente essas classes e suas
 * funcionalidades. Na classe principal, instancie uma universidade, crie diferentes tipos de funcionários e adicione à
 * universidade, e gere a folha de pagamento.
 *
 */
public class Question08_01 {

    public static void main(String[] args) {

        // Instanciando uma nova Universidade.
        Universidade UECE = new Universidade("UECE");

        // Adicionando funcionários normais.
        UECE.addFuncionario(new Funcionario(1, "Gabrielle Fernandes Costa"));
        UECE.addFuncionario(new Funcionario(2, "Rebeca Barbosa Lima"));
        UECE.addFuncionario(new Funcionario(3, "Luiz Carvalho Fernandes"));

        // Adicionando professores.
        UECE.addFuncionario(new Professor(11, "Julian Melo Martins",
                Professor.TITULARIDADE.MESTRE, Funcionario.CARGA_HORARIA.QUARENTA_HORAS_SEMANAIS, false));
        UECE.addFuncionario(new Professor(12, "Arthur Fernandes Rodrigues",
                Professor.TITULARIDADE.MESTRE, Funcionario.CARGA_HORARIA.VINTE_HORAS_SEMANAIS, false));
        UECE.addFuncionario(new Professor(13, "Giovana Costa Santos",
                Professor.TITULARIDADE.DOUTOR, Funcionario.CARGA_HORARIA.QUARENTA_HORAS_SEMANAIS, true));

        // Adicionando Técnicos.
        UECE.addFuncionario(new Tecnico(21, "Beatrice Ferreira Rodrigues", 10));
        UECE.addFuncionario(new Tecnico(22, "Vinícius Pereira Barros", 10));
        UECE.addFuncionario(new Tecnico(23, "Raissa Ribeiro Pereira", 20));
        UECE.addFuncionario(new Tecnico(24, "Isabelle Rodrigues Carvalho", 5));

        // Adicionando Secretários.
        UECE.addFuncionario(new Secretario(31, "Giovana Dias Santos", Funcionario.CARGA_HORARIA.VINTE_HORAS_SEMANAIS));
        UECE.addFuncionario(new Secretario(32, "Gustavo Cunha Correia", Funcionario.CARGA_HORARIA.TRINTA_HORAS_SEMANAIS));
        UECE.addFuncionario(new Secretario(33, "José Alves Pereira", Funcionario.CARGA_HORARIA.VINTE_HORAS_SEMANAIS));
        UECE.addFuncionario(new Secretario(34, "Letícia Azevedo Souza", Funcionario.CARGA_HORARIA.QUARENTA_HORAS_SEMANAIS));

        // Imprimendo as Folhas de Pagamento de Todos Funcionários.
        UECE.showFolhaPagamento();

        // Fim ToDO emotiocon feliz aqui!
    }
}
