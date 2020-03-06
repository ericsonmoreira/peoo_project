package br.com.uece.peoo.model;

/**
 * Crie uma classe denominada Elevador para armazenar as informações de um elevador dentro
 * de um prédio. A classe deve armazenar o andar atual (térreo = 0), total de andares no prédio,
 * excluindo o térreo, capacidade do elevador, e quantas pessoas estão presentes nele. A classe deve
 * também disponibilizar os seguintes métodos:
 * a) construtor: que deve receber como parâmetros a capacidade do elevador e o total de
 * andares no prédio (os elevadores sempre começam no térreo e vazio);
 * b) entra: para acrescentar uma pessoa no elevador (só deve acrescentar se ainda houver
 * espaço);
 * c) sai: para remover uma pessoa do elevador (só deve remover se houver alguém dentro
 * dele);
 * d) sobe: para subir um andar (não deve subir se já estiver no último andar);
 * e) sobe (andar): para subir até o andar passado por parâmetro (não deve subir se já estiver no
 * último andar);
 * f) desce: para descer um andar (não deve descer se já estiver no térreo);
 * g) desce (andar): para descer até o andar especificado no parâmetro (não deve descer se já
 * estiver no térreo);
 * h) podeEntrar: verifica se ainda há espaço quando uma nova pessoa quer entrar no elevador
 */
public class Elevador {

    // Terreo = 0
    private int andarAtual;

    // Total de andares desconsiderando o Terreo.
    private int totalAndares;

    // Capacidade do elevador.
    private int capElevador;

    // Quantas pessoas estão presentes.
    private int pessoasPresentes;

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public int getCapElevador() {
        return capElevador;
    }

    public void setCapElevador(int capElevador) {
        this.capElevador = capElevador;
    }

    public int getPessoasPresentes() {
        return pessoasPresentes;
    }

    public void setPessoasPresentes(int pessoasPresentes) {
        this.pessoasPresentes = pessoasPresentes;
    }

    /**
     * a. Construtor: que deve receber como parâmetros a capacidade do elevador e o total de
     * andares no prédio (os elevadores sempre começam no térreo e vazio).
     *
     * @param capElevador Capacidade do Elevador.
     * @param totalAndares Total de andares que o elevador por ir.
     */
    public Elevador(int capElevador, int totalAndares) {
        this.andarAtual = 0; // Andar inicial é o terreo.
        this.totalAndares = totalAndares + 1; //  +1 por que o 0 é o terreo.
        this.capElevador = capElevador;
        this.pessoasPresentes = 0; // sem nenhuma pessoa inicialmente.
    }

    /**
     * b. entra: para acrescentar uma pessoa no elevador (só deve acrescentar se ainda houver espaço).
     *
     * @return true se uma pessoa entrou com sucesso, false, caso contrário.
     */
    public boolean entra() {
        if (podeEntrar()) {
            pessoasPresentes++;
            return true;
        }
        return false;
    }

    /**
     * c. sobe: para subir um andar (não deve subir se já estiver no último andar);
     *
     * @return true se o elevador subiu com sucesso, false, caso contrário.
     */
    public boolean sobe() {
        if (andarAtual < totalAndares) {
            andarAtual++;
            return true;
        }
        return false;
    }

    /**
     * Tenta mudar o andar.
     *
     * @param andar Andar para onde vai.
     * @return true se o andar é válido, false, caso contratio.
     */
    public boolean irAndar(int andar) {
        if (andar >= 0 && andar <= totalAndares) {
            setAndarAtual(andar);
            return true;
        }
        return false;
    }

    /**
     * Uma pessoa tentando sair do elevador.
     *
     * @return true, caso alguém saia com sucesso, false, caso contrário.
     */
    public boolean sai() {
        if (pessoasPresentes > 0) {
            pessoasPresentes--;
            return true;
        }
        return false;
    }

    /**
     * Elevandor tentando descer.
     *
     * @return true, caso o elevador consiga descer, false, caso contrário.
     */
    public boolean desce() {
        if (andarAtual > 0) {
            andarAtual--;
            return true;
        }
        return false;
    }

    /**
     * @return true se algué pode entrar no elevador, false caso contrário.
     */
    public boolean podeEntrar() {
        return pessoasPresentes < capElevador;
    }

    @Override
    public String toString() {
        return "Elevador{" +
                "andarAtual=" + andarAtual +
                ", totalAndares=" + totalAndares +
                ", capElevador=" + capElevador +
                ", pessoasPresentes=" + pessoasPresentes +
                '}';
    }
}
