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

    public void addTv(Televisao televisao){
        this.televisores.add(televisao);
    }

    public void aumentarVolume() {
        this.televisores.forEach(televisao -> televisao.alterarVolume(Televisao.COMANDO_TV.UP));
    }

    public void diminuirVolume() {
        this.televisores.forEach(televisao -> televisao.alterarVolume(Televisao.COMANDO_TV.DOWN));
    }

    public void sintonizarCanal(Canal canal) {
        this.televisores.forEach(televisao -> televisao.setCanalAtual(canal));
    }

    public void proximoCanal() {
        this.televisores.forEach(televisao -> televisao.alterarCanal(Televisao.COMANDO_TV.UP));
    }

    public void canalAnterior() {
        this.televisores.forEach(televisao -> televisao.alterarCanal(Televisao.COMANDO_TV.DOWN));
    }

    public void informarDados() {
        this.televisores.forEach(System.out::println);
    }

    public void mostrarGrade() {
//        this.televisores.forEach(televisao -> {
//            System.out.println(televisao);
//            televisao.getCanais().forEach();
//        });
    }

    @Override
    public String toString() {
        return "ControleRemoto{" +
                "televisores=" + televisores +
                '}';
    }
}
