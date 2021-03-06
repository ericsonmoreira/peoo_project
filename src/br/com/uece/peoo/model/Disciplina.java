package br.com.uece.peoo.model;

import br.com.uece.peoo.util.JSONable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Toda disciplina possui um código, um nome, a quantidade máxima de alunos matriculados e a lista de alunos matriculados.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Disciplina extends JSONable {

    // Código da disciplina.
    private String cod;

    // Nome da disciplina.
    private String nome;

    // Quantidade máxima de alunos.
    private int quantMaxAlunos;

    // Alunos da disciplina.
    private ArrayList<Aluno> alunos;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantMaxAlunos() {
        return quantMaxAlunos;
    }

    public void setQuantMaxAlunos(int quantMaxAlunos) {
        this.quantMaxAlunos = quantMaxAlunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * Construtor padrão.
     *
     * @param cod            Código da disciplina.
     * @param nome           Nome da disciplina.
     * @param quantMaxAlunos Quantidade máxima de alunos na disciplina.
     */
    public Disciplina(String cod, String nome, int quantMaxAlunos) {
        setCod(cod);
        setNome(nome);
        setQuantMaxAlunos(quantMaxAlunos);
        setAlunos(new ArrayList<Aluno>());
    }

    public Disciplina(ArrayList<Aluno> alunos) {
        super();
        this.alunos = alunos;
    }

    /**
     * Matricular um aluno. não permitir a matrícula se a turma já está cheia.
     *
     * @param aluno
     * @return <code>true</code> caso consiga matricular o aluno, <code>false</code> caso contrário.
     */
    public boolean matricularAluno(Aluno aluno) {
        if (alunos.size() < quantMaxAlunos) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    /**
     * Gerar estatísticas: mostra as seguintes informações: o aluno que tirou maior média, quantos alunos passaram
     * por média (>=7) e quantos não passaram, a média geral da turma
     */
    public void gerarEstatisticas() {
        Aluno alunoMaiorMedia = alunos.stream().max(Comparator.comparing(Aluno::getMedia)).get(); // Pega o Aluno com a maior média.
        int quantPassaram = (int) alunos.stream().filter(aluno -> aluno.getMedia() >= 7).count(); // Quantidade de alunos que passaram por média.
        // Pegando a média geral dos alunos.
        double mediaGeral = alunos.stream().mapToDouble(Aluno::getMedia).sum() / getAlunos().size();
        // Nota mental: pegar o somatorio de alguma coisa usando stream(), sempre usar o
        // mad + o tipo primitovo (mapDouble, mapInt, etc) seguido de sum() em vez de usar o método reduce.
        System.out.println("Maior Média: " + alunoMaiorMedia.getMedia() + ", Nome: " + alunoMaiorMedia.getNome());
        System.out.println("Quantidade de alunos que passaram por média: " + quantPassaram);
        System.out.println("Quantidade de alunos que não passaram: " + (getAlunos().size() - quantPassaram));
        System.out.println("Média Geral dos alunos:" + mediaGeral);
    }


    /**
     * Imprime lista dos alunos com suas notas e média por ordem alfabética CESCENTE.
     */
    public void listarAlunosPorNome() {
        alunos.stream().sorted(Comparator.comparing(Aluno::getNome)) // pega todos alunos ordenados pelo nome.
                .forEach(aluno -> System.out.println(aluno + " Média: " + aluno.getMedia())); // imprime junto com a média.
    }

    /**
     * Imprime lista dos alunos com suas notas e média por ordem DECRESCENTE de média.
     */
    public void listarAlunosPorMedia() {
        alunos.stream().sorted(Comparator.comparing(Aluno::getMedia, Comparator.reverseOrder())) // pega todos alunos ordenados por média em ordem decrescente.
                .forEach(aluno -> System.out.println(aluno + " Média: " + aluno.getMedia())); // imprime junto com a média.
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "cod='" + cod + '\'' +
                ", nome='" + nome + '\'' +
                ", quantMaxAlunos=" + quantMaxAlunos +
                ", alunos=" + alunos +
                "}" ;
    }

    /**
     * Usando JSON.
     *
     * @return Um {@link JSONObject} - uma representação do objeto em JSON.
     */
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        JSONArray alunosJsonArray = new JSONArray();
        this.alunos.forEach(aluno -> alunosJsonArray.add(aluno.toJSONObject()));
        object.put("nome", this.getNome());
        object.put("cod", this.getCod());
        object.put("quantMaxAlunos", this.getQuantMaxAlunos());
        object.put("alunos", alunosJsonArray);
        return object;
    }

}
