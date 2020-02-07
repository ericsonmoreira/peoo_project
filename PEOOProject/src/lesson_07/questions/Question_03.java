package lesson_07.questions;

import model.Aluno;
import model.Disciplina;
import util.Question;

import java.util.Random;

/**
 * 3.	Crie uma classe Aluno que represente um aluno matriculado em uma disciplina. Aluno contém um nome e uma matrícula.
 * Crie um construtor que inicialize esses valores.  Além disso, ele possui a nota das 2 provas que ele faz durante o semestre.
 * Crie métodos de get e set para todos os atributos. Crie também um método que calcula a média aritmética obtida na disciplina.
 * Crie uma classe Disciplina que representa a disciplina de Programação Estruturada e Orientada a Objetos.
 * Toda disciplina possui um código, um nome, a quantidade máxima de alunos matriculados e a lista de alunos matriculados.
 * Crie os seguintes métodos:
 * --> Matricular aluno: não permitir a matrícula se a turma já está cheia
 * --> Atribuir notas: seleciona o aluno e atribui as notas da disciplina
 * --> Alterar notas: permite o professor alterar as notas de um aluno
 * --> Gerar estatísticas: mostra as seguintes informações: o aluno que tirou maior média, quantos alunos passaram por
 * média (>=7) e quantos não passaram, a média geral da turma
 * --> Mostra lista dos alunos com suas notas e média por ordem alfabética
 * --> Mostra lista dos alunos com suas notas e média por ordem decrescente de média
 * <p>
 * Crie uma classe Main que disponibilize um menu para que o usuário (professor) possa gerenciar sua disciplina.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question_03 {

    private static final int SEMENTE = 10;
    private static final Random random = new Random(SEMENTE);

    /**
     * Gerar nota aleatória.
     *
     * @param semente Semente para gerar números aleatórios fixos.
     * @return Nota aleatória entre 0 e 10 com duas casas decimais.
     */
    public static double gerarNotaRandomica() {
        return (double) (Math.round(random.nextDouble() * 1000)) / 100;
    }

    public static void main(String[] args) {

        // array de alunos
        Aluno[] alunos = {
                new Aluno("Antônio Ferreira Rodrigues", 1),
                new Aluno("Vinicius Ferreira Correia", 2),
                new Aluno("Tânia Lima Castro", 3),
                new Aluno("Carla Souza Costa", 4),
                new Aluno("Giovanna Cardoso Ferreira", 5),
                new Aluno("Letícia Cunha Dias", 6),
                new Aluno("Livia Correia Azevedo", 7),
                new Aluno("Luís Carvalho Almeida", 8),
                new Aluno("Tiago Castro Souza", 9),
                new Aluno("José Rodrigues Cardoso", 10),
                new Aluno("José Rodrigues Cardoso Segundo", 11) // Nesse aqui vai dar erro.
        };

        // Criando a Disciplina.
        Disciplina PEOO = new Disciplina("CT874", "PEOO", 10);

        // Imprime as informações da Disciplina.
        System.out.println(PEOO);

        System.out.println("------------------------------------------------------------");
        System.out.println("Matriculando Alunos");
        for (Aluno aluno : alunos) {
            aluno.setNp1(gerarNotaRandomica());
            aluno.setNp2(gerarNotaRandomica());
            System.out.println("Matriculando: " + aluno.getNome() + ", resultado: " + (PEOO.matricularAluno(aluno) ? "OK" : "ERRO"));
        }

        // Imprime as informações da Disciplina depois das Matrículas dos Alunos.
        System.out.println("------------------------------------------------------------");
        System.out.println(PEOO);

        System.out.println("------------------------------------------------------------");
        System.out.println("Ordenando por média (DECRESCENTE):");
        PEOO.listarAlunosPorMedia();

        System.out.println("------------------------------------------------------------");
        System.out.println("Ordenado por nome (CESCENTE):");
        PEOO.listarAlunosPorNome();

        System.out.println("------------------------------------------------------------");
        System.out.println("Estatísticas:");
        PEOO.gerarEstatisticas();

        System.out.println("------------------------------------------------------------");
        // So por curiosidade. =P
        System.out.println(PEOO.toStringJSON());
        Question.createFileJSON("disciplina_peoo.json", PEOO.toStringJSON());

    }
}
