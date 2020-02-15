package br.com.uece.peoo.model;

import org.json.simple.JSONObject;

/**
 * Contato de Infância.
 */
public class ContatoInfancia extends Contato {

    private int idade;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ContatoInfancia(String nome, String telefone, int idade) {
        super(nome, telefone); // Chama o construtor da classe mãe.
        setIdade(idade);
    }

    /**
     * @return Uma {@link String} representando um Contato de Infância.
     */
    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", idade='" + idade + '\'' +
                "}";
    }

    /**
     * @return
     */
    @Override
    public JSONObject toJSONObject() {
        var object = super.toJSONObject();
        object.put("idade", this.idade);
        return object;
    }

}
