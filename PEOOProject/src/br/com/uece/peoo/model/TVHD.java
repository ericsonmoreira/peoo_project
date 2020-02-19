package br.com.uece.peoo.model;

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
     *
     * @param id         nome do fabricante mais o modelo. exemplo: LG345.
     * @param voloume    volume inicial.
     * @param canalAtual Canal atual.
     */
    public TVHD(String id, int voloume, Canal canalAtual) {
        super(id, voloume, canalAtual);
    }
}
