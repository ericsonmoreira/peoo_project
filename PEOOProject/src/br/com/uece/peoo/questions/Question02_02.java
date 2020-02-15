package br.com.uece.peoo.questions;

import br.com.uece.peoo.util.Question;
import br.com.uece.peoo.util.Triangle;

/**
 * 2. Faça o algoritmo que, dadas três dimensões (A, B e C), faça o seguinte:
 * a. Verifique se as três dimensões formam um triângulo. Caso não formem, apresentar uma mensagem para o usuário.
 * Obs.: Três dimensões conseguem formar um triângulo, quando cada uma dessas dimensões, individualmente, for
 * menor que a soma das outras duas dimensões.
 * <p>
 * b. Caso as dimensões formem um triângulo, apresentar qual tipo de triângulo elas formam. Sabe-se que:
 * -> Triângulo do tipo equilátero  possui os três lados iguais;
 * -> Triângulo do tipo isósceles  possui dois lados iguais;
 * -> Triângulo do tipo escaleno  possui os três lados diferentes.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question02_02 extends Question {

    public static void main(String[] args) {

        // Pegando as dimenções.
        System.out.println("Digite a Dimenção A:");
        double a = scanner.nextDouble();
        System.out.println("Digite a Dimenção B:");
        double b = scanner.nextDouble();
        System.out.println("Digite a Dimenção C:");
        double c = scanner.nextDouble();

        // Instanciando um Triângulo.
        Triangle triangle = new Triangle(a, b, c);

        if (triangle.isTriangle()) {
            System.out.println("ABC é um Triangulo do tipo: " + triangle.getTipeTriangle() + ".");
        } else {
            System.out.println("ABC não é um Triangulo.");
        }

    }

}
