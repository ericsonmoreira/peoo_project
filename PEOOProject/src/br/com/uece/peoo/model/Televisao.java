package br.com.uece.peoo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Crie uma classe Televisão que contém como atributos um id (pode ser o nome do
 * fabricante e um número de modelo qualquer, ex: LG345), o volume, o canal atual e uma
 * lista de canais disponíveis. Crie uma constante com o volume máximo = 10 e outra com o
 * volume mínimo = 0. Crie um construtor que receba como parâmetro o volume inicial e o
 * canal inicial da televisão e inicialize a lista e canais com os canais abertos (8 – Record - F,
 * 10 – Globo -F, 12 – Band – F). Crie métodos de get e set para o volume.
 */
public class Televisao {

    /**
     * Enum que representa os comandos de aumentar e diminuir volume.
     */
    enum COMANDO_VOL_TV {
        UP_VOL(1), DOWN_VOL(-1);
        private int valor;
        COMANDO_VOL_TV(int valor) {
            this.valor = valor;
        }
    }

    enum COMANDO_CH_TV {
        UP_CH, DOW_CH;
    }

    // Constantes
    private static final int VOL_MIN = 0; // volume minimo
    private static final int VOL_MAX = 10; // volumoe maximo

    private String id;

    private int voloume;

    private Canal canalAtual;

    private List<Canal> canais;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVoloume() {
        return voloume;
    }

    /**
     * Volumeno naum pode ser maior que VOL_MAX nem menor que VOL_MIN.
     * Caso o naum obedeca essa condicao, o valor permanece o mesmo.
     *
     * @param voloume volume da TV entre VOL_MAX e VOL_MIN.
     */
    public void setVoloume(int voloume) {
        this.voloume = (voloume > VOL_MAX || voloume < VOL_MIN ? this.voloume: voloume);
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
        if(!canais.contains(canalAtual)) { // Se o canal atual não tiver na lista de

        }
    }

    public List<Canal> getCanais() {
        return canais;
    }

    public void setCanais(List<Canal> canais) {
        this.canais = canais;
    }

    /**
     * Construtor que inicialize a lista e canais com os canais abertos (8 – Record - F, 10 – Globo -F, 12 – Band – F)
     *
     * @param id nome do fabricante mais o modelo. exemplo: LG345.
     * @param voloume volume inicial.
     * @param canalAtual Canal atual.
     */
    public Televisao(String id, int voloume, Canal canalAtual) {
        setId(id);
        setVoloume(voloume);
        setCanalAtual(canalAtual);
        this.canais = Arrays.asList(
                new Canal(8, "Record", false),
                new Canal(10, "Globo", false),
                new Canal(12, "Band", false)
        ); // Inicializando os canais padrao
    }

    /**
     * recebe como parâmetro se aumenta ou diminui. No primeiro caso, incrementa o volume da TV em 1 unidade,
     * mas não pode ultrapassar o máximo. No segundo caso, decrementa o volume da TV em 1 unidade, mas não pode
     * ultrapassar o mínimo.
     *
     * @param COMANDOVOLTV {@link COMANDO_VOL_TV} UP_VOL ou DOWN_VOL.
     */
    public void alterarVolume(COMANDO_VOL_TV COMANDOVOLTV){
        setVoloume(getVoloume() + COMANDOVOLTV.valor);
    }

    /**
     * recebe como um parâmetro um canal e retorna verdadeiro, caso o canal já exista na programação da TV,
     * e falso caso contrário.
     *
     * @param canal Canal a ser verificado.
     * @return true se o canal existir e false caso contrario.
     */
    public boolean canalExistente(Canal canal){
        return canais.contains(canal);
    }

    /**
     * Recebe como parâmetro um número, representando o canal da TV desejado, busca na lista de canais o
     * canal com esse número e, caso exista, altera o canal atual para este. Caso não exista, apresenta
     * mensagem de canal inexistente.
     *
     * @param num numero do canal desejado.
     */
    public void sintonizar(int num){
        // naum parece mas estah fazendo exatamente o que pede.
        canais.stream().filter(canal -> canal.getNumero() == num).findFirst().ifPresentOrElse(
                canal -> setCanalAtual(canal), () -> System.out.println("Não Existe Canal com o Num: " + num));
    }

    /**
     * Recebe como parâmetro uma lista com os canais disponíveis, mas só insere na lista de canais
     * disponíveis os canais novos (não pré-cadastrados) e não HDs.
     *
     * @param canalList Lista de {@link Canal}
     */
    public void cadastrarCanais(ArrayList<Canal> canalList){
        // serio mesmo, naum parece mais estah fazendo o que pede
        canalList.stream().
                filter(canal -> !this.canais.contains(canal)).filter(canal -> !canal.isHD()).forEach(this.canais::add);
    }

    /**
     * Recebe como parâmetro se seleciona o próximo canal ou o anterior e altera o canal atual de acordo com o
     * solicitado. Se o canal atual for o último da lista e for solicitado próximo canal, deve-se alterar o canal
     * para o primeiro da lista. Já se for o primeiro canal e solicitar o anterior, deve-se setar o canal atual
     * como o último da lista.
     */
    public void alterarCanal(COMANDO_CH_TV comando){

    }

    /**
     * - informar dados: mostra o canal atual (nome, número e se é HD) e o volume atual.
     */
    public  void informarDados(){
        System.out.println(toString());
    }

    /**
     * mostrar grade: apresenta a lista ordenada de canais disponíveis, mostrando todos os
     * dados de cada canal. Ordenados pelo numero do canal.
     */
    public void mostarGrade() {
        // Ordenados pelo numero do canal.
        canais.stream().sorted(Comparator.comparing(Canal::getNumero)).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Televisao{" +
                "id='" + id + '\'' +
                ", voloume=" + voloume +
                ", canalAtual=" + canalAtual +
                ", canais=" + canais +
                '}';
    }
}
