package br.com.uece.peoo.model;

public class SmartTV extends Televisao {

    private int polegadas; // polegadas da Smart TV

    public int getPolegadas() {
        return polegadas;
    }

    public void setPolegadas(int polegadas) {
        this.polegadas = polegadas;
    }

    /**
     * Construtor que inicialize a lista e canais com os canais abertos (8 – Record - F, 10 – Globo -F, 12 – Band – F)
     *
     * @param id         nome do fabricante mais o modelo. exemplo: LG345.
     * @param voloume    volume inicial.
     * @param canalAtual Canal atual.
     * @param polegadas  Polegadas da {@link SmartTV}
     */
    public SmartTV(String id, int voloume, Canal canalAtual, int polegadas) {
        super(id, voloume, canalAtual);
        this.polegadas = polegadas;
    }
}
