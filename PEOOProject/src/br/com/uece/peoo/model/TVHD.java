package br.com.uece.peoo.model;

import java.util.ArrayList;

/**
 * A segunda classe cadastra novos canais apenas se eles forem HD.
 */
public class TVHD extends Televisao {

    /**
     * Enum para os modelos.
     */
    public enum MODELO{
        LED, PLASMA, HD;
    }

    private MODELO modelo;

    /**
     * Construtor que inicialize a lista e canais com os canais abertos (8 – Record - F, 10 – Globo -F, 12 – Band – F)
     *  @param id         nome do fabricante mais o modelo. exemplo: LG345.
     * @param canalAtual Canal atual.
     * @param modelo modele da TV.
     */
    public TVHD(String id, int volume, Canal canalAtual, MODELO modelo) {
        super(id, volume, canalAtual);
        this.modelo = modelo;
    }

    /**
     * cadastra novos canais apenas se eles forem HD.
     *
     * @param canalList Lista de {@link Canal}
     */
    @Override
    public void cadastrarCanais(ArrayList<Canal> canalList) {
        canalList.stream().
                filter(canal -> !this.canais.contains(canal)).filter(canal -> canal.isHD()).forEach(this.canais::add);
    }

    @Override
    public String toString() {
        return "TVHD{" +
                "modelo=" + modelo +
                ", id='" + id + '\'' +
                ", voloume=" + voloume +
                ", canalAtual=" + canalAtual +
                ", canais=" + canais +
                "} " + super.toString();
    }
}
