package br.com.uece.peoo.model;

/**
 * Representa um canal de TV, que possui como atributos um número, 
 * um nome e um booleano HD, que indica se o canal é digital ou não.
 */
public class Canal {

    private int numero; // numero do canal

    private String nome; // nome do canal

    private boolean HD; // HD?

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isHD() {
        return HD;
    }

    public void setHD(boolean HD) {
        this.HD = HD;
    }

    /**
     * Construtor padrao.
     *
     * @param numero numero do canal.
     * @param nome nome do canal
     * @param HD boloeando para indicar se so canal eh HD ou naum.
     */
    public Canal(int numero, String nome, boolean HD) {
        this.numero = numero;
        this.nome = nome;
        this.HD = HD;
    }

    @Override
    public String toString() {
        return "Canal{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", HD=" + HD +
                '}';
    }
}
