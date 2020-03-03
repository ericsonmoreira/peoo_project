package br.com.uece.peoo.model;

public class Retangulo implements FiguraGeometrica{

    // base
    private double b;

    // autura
    private double h;

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double calcularArea() {
        return b * h;
    }

    public Retangulo(double b, double h) {
        this.b = b;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Retangulo{" +
                "b=" + b +
                ", h=" + h +
                '}';
    }
}
