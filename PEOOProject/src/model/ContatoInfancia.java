package model;

import org.json.simple.JSONObject;

public class ContatoInfancia extends Contato {

    private int idade;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ContatoInfancia(String name, String fone, int idade) {
        super(name, fone);
        setIdade(idade);
    }

    @Override
    public JSONObject toJSONObject() {
        var object = super.toJSONObject();
        object.put("idade", this.idade);
        return object;
    }

    @Override
    public String toString() {
        return "[Nome: " + this.name + ", telefone: " + this.fone + ", idade: " + this.idade +"]";
    }
}
