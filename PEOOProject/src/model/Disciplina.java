package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.JSONable;

/**
 * Toda disciplina possui um código, um nome, a quantidade máxima de alunos matriculados e a lista de alunos matriculados.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Disciplina extends JSONable{

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
	 * @param cod Código da disciplina.
	 * @param nome Nome da disciplina.
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
	 * Imprime lista dos alunos com suas notas e média por ordem alfabética crescentre.
	 */
	public void listAlunosPorNome() {
		ArrayList<Aluno> alunosCopy = new ArrayList<Aluno>();
		// Peda o nome de todos alunos
		this.alunos.forEach(aluno -> alunosCopy.add(aluno));
		Collections.sort(alunosCopy, new ComparadorAlunosNome());
		alunosCopy.forEach(aluno -> System.out.println("Aluno: " + aluno.getNome() + ", Média: " + aluno.getMedia()));
	}
	
	/**
	 * Imprime lista dos alunos com suas notas e média por ordem decrescente de média.
	 */
	public void listAlunosPorMedia() {
		ArrayList<Aluno> alunosCopy = new ArrayList<Aluno>();
		// Peda o nome de todos alunos
		this.alunos.forEach(aluno -> alunosCopy.add(aluno));
		Collections.sort(alunosCopy, new ComparadorAlunosMedia());
		alunosCopy.forEach(aluno -> System.out.println("Aluno: " + aluno.getNome() + ", Média: " + aluno.getMedia()));
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
	
	// Aqui vai classes internas para comparar alunos.
	
	/**
	 * Classe para comprar alunos pelo nome em ordem crescente.
	 * 
	 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
	 */
	private class ComparadorAlunosNome implements Comparator<Aluno>{
		
		@Override
		public int compare(Aluno o1, Aluno o2) {
			if (o1.getNome().compareTo(o2.getNome()) < 0) return -1;
			else if (o1.getNome().compareTo(o2.getNome()) > 0) return 1;
			else return 0;
		}
	}
	
	/**
	 * Classe para comprar alunos pela Média das notas em ordem decrescente.
	 * 
	 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
	 */
	private class ComparadorAlunosMedia implements Comparator<Aluno>{
		
		@Override
		public int compare(Aluno o1, Aluno o2) {
			if (o1.getMedia() > o2.getMedia()) return -1;
			else if (o1.getMedia() < o2.getMedia()) return 1;
			else return 0;
		}
	}
	
}
