package model;

import org.json.simple.JSONObject;
import util.JSONable;

/**
 * Aluno contém um nome e uma matrícula.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Aluno extends JSONable{
	
	private String nome;
	
	private int matricula;

	private double np1;
	
	private double np2;
	
	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public double getNp1() {
		return np1;
	}

	public void setNp1(double np1) {
		this.np1 = np1;
	}

	public double getNp2() {
		return np2;
	}

	public void setNp2(double np2) {
		this.np2 = np2;
	}

	/**
	 * Calcula a média do Aluno.
	 * 
	 * @return Media aredondada em duas casas decimais.
	 */
	public double getMedia() {
		return (double) Math.round((100 * (np1 + np2)/2))/100;
	}
	
	/**
	 * Contrutor Padrão.
	 * 
	 * @param nome Nome do aluno.
	 * @param matricula Matrícula do aluno.
	 */
	public Aluno(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.np1 = 0;
		this.np2 = 0;
	}

	public Aluno() {
		this("", -1);
	}
	
	/**
	 * Atribuir notas: seleciona o aluno e atribui as notas da disciplina
	 * 
	 * @param np1 Nota parcial 1.
	 * @param np2 Nota parcial 2.
	 * @param aluno Aluno.
	 */
	public void atribuirNotas(double np1, double np2) {
		setNp1(np1);
		setNp2(np2);
	}

	@Override
	public String toString() {
		return "Aluno{" +
				"nome='" + nome + '\'' +
				", matricula=" + matricula +
				", np1=" + np1 +
				", np2=" + np2 +
				"}";
	}

	/**
	 * Usando JSON.
	 * 
	 * @return Um {@link JSONObject} - uma representação do objeto em JSON.
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put("matricula", this.matricula);
		object.put("nome", this.nome);
		object.put("np1", this.np1);
		object.put("np2", this.np2);
		return object;
	}
	
}
