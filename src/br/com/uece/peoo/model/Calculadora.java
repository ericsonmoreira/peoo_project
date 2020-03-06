package br.com.uece.peoo.model;

/**
 * Implemente uma classe para representar uma calculadora. Ofereça, através de métodos
 * específicos, as funções aritméticas básicas de adição, subtração, multiplicação e divisão. A
 * calculadora deve manter o último resultado em memória e as operações aritméticas recebem um
 * único parâmetro que alteram esse resultado após a operação. A calculadora deve oferecer também
 * um método que limpa esse valor acumulado. Considere que o resultado inicia com 0.
 * Codifique o método Main para poder testar sua classe: nesse método, crie uma instância
 * (uma calculadora), efetue algumas operações e imprima o resultado.
 */
public class Calculadora {

    private double ultimoResultado;

    public double getUltimoResultado() {
        return ultimoResultado;
    }

    public void setUltimoResultado(double ultimoResultado) {
        this.ultimoResultado = ultimoResultado;
    }

    public void adicao(double num) {
        ultimoResultado += num;
    }

    public void subitracao(double num) {
        ultimoResultado -= num;
    }

    public void multiplicacao(double num) {
        ultimoResultado *= num;
    }

    public void divisao(double num) {
        ultimoResultado /= num;
    }

    public void limparValorAcumulado() {
        setUltimoResultado(0);
    }

    public Calculadora() {
        this.ultimoResultado = 0;
    }

    @Override
    public String toString() {
        return "Calculadora{" +
                "ultimoResultado=" + ultimoResultado +
                '}';
    }

}
