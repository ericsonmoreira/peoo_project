package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.*;

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

        ArrayList<FiguraGeometrica> figurasGeometricas = new ArrayList<>();
        figurasGeometricas.add(new Quadrado(1));
        figurasGeometricas.add(new Quadrado(2));
        figurasGeometricas.add(new Quadrado(3));
        figurasGeometricas.add(new Quadrado(4));
        figurasGeometricas.add(new Quadrado(5));
        figurasGeometricas.add(new Quadrado(6));

        figurasGeometricas.add(new Retangulo(10, 20));
        figurasGeometricas.add(new Retangulo(100, 20));
        figurasGeometricas.add(new Retangulo(1, 20));
        figurasGeometricas.add(new Retangulo(150, 2));
        figurasGeometricas.add(new Retangulo(160, 2000));


        figurasGeometricas.forEach(figura -> System.out.println(figura + " | area=" + figura.calcularArea()));

    }
}
