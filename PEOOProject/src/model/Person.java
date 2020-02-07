package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.JSONable;

/**
 * Classe que representa uma pessoa com idade (age) e nome (name).
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Person extends JSONable {

    private int age;

    private String name;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    /**
     * Construtor por objeto JSON.
     *
     * @param jsonObject Um {@link JSONObject} já no padrão de um objeto {@link Person}.
     */
    public Person(JSONObject jsonObject) {
        this((String) jsonObject.get("name"), (int) jsonObject.get("age"));
    }

    /**
     * Construtor por String JSON.
     *
     * @param jsonString uma {@link String} no formato JSON.
     */
    public Person(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(jsonString);
            this.setName((String) object.get("name"));
            this.setAge((int) object.get("age"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                "}";
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
