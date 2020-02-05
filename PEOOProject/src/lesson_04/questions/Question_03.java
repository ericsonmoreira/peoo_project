package lesson_04.questions;

import util.Potencia;
import util.Question;

/**
 * Escreva uma classe “Potência” que tem dois atributos inteiros: x, y. Crie um construtor que
 * recebe esses valores e um método “elevar” que calcula e retorna o valor de x elevado a y (atenção:
 * não vale usar classes matemáticas!)
 * <p>
 * Crie uma classe executável para testar a classe acima.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question_03 extends Question {

    public static void main(String[] args) {

        System.out.println("Digite o Valor de X:");
        int X = scanner.nextInt();

        System.out.println("Digite o Valor de Y:");
        int Y = scanner.nextInt();

        Potencia potencia = new Potencia(X, Y);

        System.out.println("X ^ Y = " + potencia.elevar());

    }

}
