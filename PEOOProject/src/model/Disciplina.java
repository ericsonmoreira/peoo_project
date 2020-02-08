package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import util.JSONable;

import java.util.ArrayList;
import java.util.Collections;
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
        Aluno alunoMaiorMedia = new Aluno();
        int quantPassaram = 0;
        double mediaGeral = 0;
        for (Aluno aluno : alunos) {
            if (aluno.getMedia() >= alunoMaiorMedia.getMedia()) {
                alunoMaiorMedia = aluno;
            }
            if (aluno.getMedia() >= 7) {
                quantPassaram++;
            }
            mediaGeral += aluno.getMedia();
        }
        mediaGeral = mediaGeral / getAlunos().size();
        System.out.println("Maior Média: " + alunoMaiorMedia.getMedia() + ", Nome: " + alunoMaiorMedia.getNome());
        System.out.println("Quantidade de alunos que passaram por média: " + quantPassaram);
        System.out.println("Quantidade de alunos que não passaram: " + (getAlunos().size() - quantPassaram));
        System.out.println("Média Geral dos alunos:" + mediaGeral);
    }


    /**
     * Imprime lista dos alunos com suas notas e média por ordem alfabética CESCENTE.
     */
    public void listarAlunosPorNome() {
        var alunosCopy = new ArrayList<Aluno>();
        this.alunos.forEach(aluno -> alunosCopy.add(aluno)); // Pega os nomes de todos alunos.
        alunosCopy.sort(Comparator.comparing(aluno -> aluno.getNome())); // Ordena pelo nome.
        alunosCopy.forEach(aluno -> System.out.println(aluno + " Média: " + aluno.getMedia())); // Imprime o aluno + a média.
    }

    /**
     * Imprime lista dos alunos com suas notas e média por ordem DECRESCENTE de média.
     */
    public void listarAlunosPorMedia() {
        var alunosCopy = new ArrayList<Aluno>();
        this.alunos.forEach(aluno -> alunosCopy.add(aluno)); // Pega os nomes de todos alunos.
        alunosCopy.sort(Comparator.comparing(aluno -> aluno.getMedia())); // Ordena mela média.
        Collections.reverse(alunosCopy); // Inverte a ordem.
        alunosCopy.forEach(aluno -> System.out.println(aluno + " Média: " + aluno.getMedia())); // Imprime o aluno + a média.
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
