package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.JSONable;

/**
 * Obs.: O nome dessa classe está em português porque já existe uma classe com o nome Person nesse pacote.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Contato extends JSONable {

    protected String name;

    protected String telefone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Construtor genérico que cria a classe com os atributos com {@link String} vazias.
     */
    public Contato() {
        this("", "");
    }

    /**
     * Construtor que recebeum {@link JSONObject}
     *
     * @param jsonObject
     */
    public Contato(JSONObject jsonObject) {
        this((String) jsonObject.get("name"), (String) jsonObject.get("fone"));
    }

    /**
     * Construtor que recebe uma {@link String} no padão JSON.
     *
     * @param jsonString
     */
    public Contato(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(jsonString);
            this.setName((String) object.get("name"));
            this.setTelefone((String) object.get("fone"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Construtor com atributos.
     *
     * @param name Nome da pessoa.
     * @param telefone Telefone da pessoa.
     */
    public Contato(String name, String telefone) {
        setName(name);
        setTelefone(telefone);
    }

    /**
     * Imprime os dados.
     */
    public void mostrarDados() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "[Nome: " + this.name + ", telefone: " + this.telefone + "]";
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        var object = new JSONObject();
        object.put("fone", this.telefone);
        object.put("name", this.name);
        return object;
    }

}
