package model;

import org.json.simple.JSONObject;

import util.JSONable;

/**
 * 
 * Classe que representa uma pessoa com idade (age) e nome (name). 
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Person extends JSONable{
	
	private int age;

	private String name;

	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	
	/**
	 * Construtor por String JSON.
	 * 
	 * @param jsonString uma {@link String} no formato JSON.
	 */
	public Person(String jsonString) {
		
		
	}
	
	/**
	 * Construtor por objeto JSON.
	 * 
	 * @param jsonObject Um {@link JSONObject} já no padrão de um objeto {@link Person}.
	 */
	public Person(JSONObject jsonObject) {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[Nome: " + this.name + "; Idade: " + this.age + "]";
	}

	@Override
	@SuppressWarnings("unchecked")
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put("name", this.name);
		object.put("idade", this.age);
		return object;
	}
	
}
