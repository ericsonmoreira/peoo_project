package model;

import org.json.simple.JSONObject;

/**
 *
 */
public class ContatoTrabalho extends Contato {

    // Setor onde trabalha (informática, rh, finanças...).
    private String setor;

    public ContatoTrabalho(String name, String fone, String setor) {
        super(name, fone);
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "[Nome: " + this.name + ", telefone: " + this.fone + ", setor: " + this.setor +"]";
    }

    @Override
    public JSONObject toJSONObject() {
        var object = super.toJSONObject();
        object.put("setor", this.setor);
        return object;
    }

}
