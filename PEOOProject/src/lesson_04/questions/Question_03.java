package lesson_04.questions;

import util.Comparavel;
import util.Question;

/**
 * Escreva uma classe “Potência” que tem dois atributos inteiros: x, y. Crie um construtor que
 * recebe esses valores e um método “elevar” que calcula e retorna o valor de x elevado a y (atenção: 
 * não vale usar classes matemáticas!) 
 * 
 * Crie uma classe executável para testar a classe acima.
 * 
 * @author ericson
 *
 */
public class Question_03 extends Question{

	public static void main(String[] args) {

		// Pegando o valor de 
		System.out.println("Digite o Valor para o Comparável:");
		Comparavel c = new Comparavel(scanner.nextInt());

		// Pegando o Valor do 
		System.out.println("Digite o valor de X:");
		int x = scanner.nextInt();

		System.out.println("É Diferente? " + (c.eDiferenteDe(x) ? "Sim": "Não"));
		System.out.println("É Maior ou Igual? " + (c.eMaiorOuIgual(x) ? "Sim": "Não"));
		System.out.println("É Menor ou Igual? " + (c.eMenorOuIgual(x) ? "Sim": "Não"));

	}

}
