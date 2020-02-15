package br.com.uece.peoo.model;

import org.json.simple.JSONObject;
import br.com.uece.peoo.util.JSONable;

public class ItemDeCompra extends JSONable {
    // Código do produto
    private int cod;

    // Nome do produto
    private String nome;

    // preço do produto
    private double preco;

    // Quantidade comprada
    private int quant;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    /**
     * Devolve o valor total pago pelo item (preço unitátio * quantidade).
     *
     * @return (preço unitátio * quantidade)
     */
    public double calcularTotal() {
        return preco * quant;
    }

    public ItemDeCompra(int cod, String nome, double preco, int quant) {
        setCod(cod);
        setNome(nome);
        setPreco(preco);
        setQuant(quant);
    }

    @Override
    public String toString() {
        return "ItemDeCompra{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quant=" + quant +
                "}";
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        object.put("cod", this.getCod());
        object.put("nome", this.getNome());
        object.put("preco", this.getPreco());
        object.put("quant", this.getQuant());
        return object;
    }

}
