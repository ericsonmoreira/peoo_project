package br.com.uece.peoo.model;


/**
 * Classe que representa um triangulo
 *
 * Referencia para calculo da area do um triangulo usando os lados;
 * https://pt.wikipedia.org/wiki/Tri%C3%A2ngulo#%C3%81rea
 *
 */
public class Triangulo extends Figura{

    // Lados de um triangulo
    private double a;
    private double b;
    private double c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcularArea() {
        double p = calcularPerimetro()/2;
        return Math.sqrt(p * (p - a)* (p - b)* (p - c));
    }

    @Override
    public double calcularPerimetro() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
