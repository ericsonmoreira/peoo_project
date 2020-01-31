package util;

import org.json.simple.JSONObject;

/**
 * 
 * Classe que representa uma pessoa com idade (age) e nome (name). 
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Person {
	
	private int age;

	private String name;

	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
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
	
	@SuppressWarnings("unchecked")
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put("name", this.name);
		object.put("idade", this.age);
		return object;
	}
	
	/**
	 * 
	 * @return {@link String} no padrão JSON.
	 */
	public String toStringJSON() {
		JSONObject object = this.toJSONObject();
		return object.toJSONString();
	}
	
}
