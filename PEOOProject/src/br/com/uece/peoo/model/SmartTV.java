package br.com.uece.peoo.model;

import java.util.ArrayList;

/**
 * A SmartTV sobrescreve o método de cadastrar canais inserindo todos os canais disponibilizados,
 * desde que não estejam já cadastrados.
 */
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

    /**
     * Inserir todos os canais disponibilizados, desde que não estejam já cadastrados.
     *
     * @param canalList Lista de {@link Canal}
     */
    @Override
    public void cadastrarCanais(ArrayList<Canal> canalList) {
        canalList.stream().filter(canal -> !this.canais.contains(canal)).forEach(this.canais::add);
    }

    @Override
    public String toString() {
        return "SmartTV{" +
                "polegadas=" + polegadas +
                ", id='" + id + '\'' +
                ", voloume=" + voloume +
                ", canalAtual=" + canalAtual +
                ", canais=" + canais +
                "} " + super.toString();
    }
}
