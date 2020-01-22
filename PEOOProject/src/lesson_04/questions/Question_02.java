package lesson_04.questions;

import util.Comparavel;
import util.Question;


/**
 * Escreva uma classe chamada “Comparavel” que tem como atributo um valor inteiro, um construtor 
 * para inicializar o atributo e os métodos “eMaiorOuIgual”, “eMenorOuIgual” e “eDiferenteDe” 
 * que recebem um valor do tipo int como parâmetro e retornam true se o valor do atributo for, 
 * respectivamente, maior ou igual, menor ou igual ou diferente do passado como parâmetro 
 * 
 * Crie uma classe executável para testar a classe acima.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Question_02 extends Question {
	
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
