package br.com.uece.peoo.model;

/**
 * Uma figura geométrica possui métodos de calcular a área e o perímetro, mas esses métodos são
 * apenas implementados nos tipos de figura, como por exemplo um círculo, triângulo e quadrado.
 *
 */
public abstract class Figura {
    /**
     * Calcula a area da figura.
     *
     * @return area da figura.
     */
    public abstract double calcularArea();

    /**
     * Calcula o perimetro da figura.
     *
     * @return perimetro da figura.
     */
    public abstract double calcularPerimetro();

    /**
     * @return String com a area e o perimetro
     */
    public String getDados(){
        return "dados{" +
                "area=" + calcularArea() +
                ", perimetro=" + calcularPerimetro() +
                '}';
    }

}
