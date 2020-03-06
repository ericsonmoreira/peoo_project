package br.com.uece.peoo.util;

/**
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Comparavel {

    private int valor;

    /**
     * Método que verifica se o X é maior que o atributo valor da classe.
     *
     * @param x Valor de X.
     * @return <code>true</code> se verdadero, caso contrário, <code>false</code>.
     */
    public boolean eMaiorOuIgual(int x) {
        if (x >= this.valor) {
            return true;
        }

        return false;
    }

    /**
     * Método que verifica se o X é menor que o atributo valor da classe.
     *
     * @param x Valor de X.
     * @return <code>true</code> se verdadero, caso contrário, <code>false</code>.
     */
    public boolean eMenorOuIgual(int x) {
        if (x <= this.valor) {
            return true;
        }

        return false;
    }

    /**
     * Método que verifica se o X é diferente do atributo valor da classe.
     *
     * @param x Valor de X.
     * @return <code>true</code> se verdadero, caso contrário, <code>false</code>.
     */
    public boolean eDiferenteDe(int x) {
        if (x != this.valor) {
            return true;
        }

        return false;
    }

    /**
     * Construtor da classe.
     *
     * @param valor
     */
    public Comparavel(int valor) {
        this.valor = valor;
    }

}
