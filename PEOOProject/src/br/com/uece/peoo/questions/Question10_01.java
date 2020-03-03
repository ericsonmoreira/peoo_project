package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Circulo;
import br.com.uece.peoo.model.Figura;
import br.com.uece.peoo.model.Quadrado;
import br.com.uece.peoo.model.Triangulo;

import java.util.ArrayList;

/**
 * Uma figura geométrica possui métodos de calcular a área e o perímetro, mas esses métodos são
 * apenas implementados nos tipos de figura, como por exemplo um círculo, triângulo e quadrado.
 *
 * Implemente essa hierarquia de classes e crie uma classe Main que armazena uma lista de figuras.
 * Execute os métodos de calcular área e perímetro de cada figura da lista.
 */
public class Question10_01 {

    public static void main(String[] args) {

        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo(2));
        figuras.add(new Circulo(3));
        figuras.add(new Circulo(4));
        figuras.add(new Circulo(5));
        figuras.add(new Circulo(6));

        figuras.add(new Quadrado(1));
        figuras.add(new Quadrado(2));
        figuras.add(new Quadrado(3));
        figuras.add(new Quadrado(4));
        figuras.add(new Quadrado(5));
        figuras.add(new Quadrado(6));

        figuras.add(new Triangulo(4, 2, 3));
        figuras.add(new Triangulo(5, 4, 3));
        figuras.add(new Triangulo(15, 20, 30));
        figuras.add(new Triangulo(4, 6, 3));
        figuras.add(new Triangulo(2, 2, 2));

        figuras.forEach(figura -> System.out.println(figura + " | " + figura.getDados()));

    }
}
