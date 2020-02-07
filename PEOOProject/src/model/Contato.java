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

    protected String nome;

    protected String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
     * Construtor que recebe um {@link JSONObject}
     *
     * @param jsonObject
     */
    public Contato(JSONObject jsonObject) {
        this((String) jsonObject.get("nome"), (String) jsonObject.get("telefone"));
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
            this.setNome((String) object.get("nome"));
            this.setTelefone((String) object.get("telefone"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Construtor com atributos.
     *
     * @param nome Nome da pessoa.
     * @param telefone Telefone da pessoa.
     */
    public Contato(String nome, String telefone) {
        setNome(nome);
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
        return "[Nome: " + this.nome + ", telefone: " + this.telefone + "]";
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        var object = new JSONObject();
        object.put("telefone", this.telefone);
        object.put("nome", this.nome);
        return object;
    }

}
