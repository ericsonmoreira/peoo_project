package model;

import org.json.simple.JSONObject;

/**
 * Contato de trabalho é um {@link Contato} com setor.
 */
public class ContatoTrabalho extends Contato {

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    // Setor onde trabalha (informática, rh, finanças...).
    private String setor;

    public ContatoTrabalho(String name, String fone, String setor) {
        super(name, fone);
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "[Nome: " + this.name + ", telefone: " + this.telefone + ", setor: " + this.setor +"]";
    }

    @Override
    public JSONObject toJSONObject() {
        var object = super.toJSONObject();
        object.put("setor", this.setor);
        return object;
    }

}
