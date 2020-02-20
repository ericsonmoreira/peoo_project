package br.com.uece.peoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. Crie uma classe ControleRemoto que pode manipular uma lista de televisões, sejam elas normais, SmartTvs ou TVHDs
 * (use polimorfismo), ao mesmo tempo. Crie um método para adicionar TVs à lista. Essa classe disponibiliza ao
 * usuários as seguintes funcionalidades da TV por meio de métodos (que simulam os botões do controle físico):
 *  aumentar volume,
 *  diminuir volume,
 *  sintonizar canal específico,
 *  próximo canal,
 *  canal anterior,
 *  informar dados, e
 *  mostrar grade.
 */
public class ControleRemoto {

    private List<Televisao> televisores;

    /**
     * Construtor padrao.
     */
    public ControleRemoto() {
        this.televisores = new ArrayList<Televisao>();
    }

    public List<Televisao> getTelevisores() {
        return televisores;
    }

    public void setTelevisores(List<Televisao> televisores) {
        this.televisores = televisores;
    }

    /**
     * Adicionando uma {@link Televisao}
     *
     * @param televisao
     */
    public void addTv(Televisao televisao){
        this.televisores.add(televisao);
    }

    /**
     * Aumentar o volume em uma unidade (maximo 10).
     */
    public void aumentarVolume() {
        this.televisores.forEach(televisao -> televisao.alterarVolume(Televisao.COMANDO_TV.UP));
    }

    /**
     * Diminuir o volume em uma unidade (mínimo 0).
     */
    public void diminuirVolume() {
        this.televisores.forEach(televisao -> televisao.alterarVolume(Televisao.COMANDO_TV.DOWN));
    }

    /**
     * Sintoniza aquele canal para todas as {@link Televisao} cadastradas.
     *
     * @param canal Canal para cadastrar.
     */
    public void sintonizarCanal(Canal canal) {
        this.televisores.forEach(televisao -> {
            if (!televisao.getCanais().contains(canal)) televisao.cadastrarCanal(canal);
            televisao.setCanalAtual(canal);
        });
    }

    /**
     * Simula o botão >>
     */
    public void proximoCanal() {
        this.televisores.forEach(televisao -> televisao.alterarCanal(Televisao.COMANDO_TV.UP));
    }

    /**
     * Simula o botão <<
     */
    public void canalAnterior() {
        this.televisores.forEach(televisao -> televisao.alterarCanal(Televisao.COMANDO_TV.DOWN));
    }

    /**
     * Imprime os dados de cada TV controlada pelo Controle Remoto.
     */
    public void informarDados() {
        this.televisores.forEach(System.out::println);
    }

    /**
     * Imprime a grade de canais de cada TV cadastrada.
     */
    public void mostrarGrade() {
        this.televisores.forEach(televisao -> televisao.mostarGrade());
    }

    @Override
    public String toString() {
        return "ControleRemoto{" +
                "televisores=" + televisores +
                '}';
    }
}
