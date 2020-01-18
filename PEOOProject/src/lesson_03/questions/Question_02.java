package lesson_03.questions;

import util.Question;
import util.Triangle;

/**
 * 
 * @author ericson
 * 2. Fa�a o algoritmo que, dadas tr�s dimens�es (A, B e C), fa�a o seguinte:
 * 		a. Verifique se as tr�s dimens�es formam um tri�ngulo. Caso n�o formem, apresentar uma mensagem para o usu�rio.	
 * 		Obs.: Tr�s dimens�es conseguem formar um tri�ngulo, quando cada uma dessas dimens�es, individualmente, for 
 * 		menor que a soma das outras duas dimens�es.
 * 
 * 		b. Caso as dimens�es formem um tri�ngulo, apresentar qual tipo de tri�ngulo elas formam. Sabe-se que:
 * 			-> Tri�ngulo do tipo equil�tero � possui os tr�s lados iguais; 
 * 			-> Tri�ngulo do tipo is�sceles � possui dois lados iguais;
 * 			-> Tri�ngulo do tipo escaleno � possui os tr�s lados diferentes.
 */
public class Question_02 extends Question{

	public static void main(String[] args) {

		// Pegando as dimen��es.
		System.out.println("Digite a Dimen��o A:");
		double a = scanner.nextDouble();
		System.out.println("Digite a Dimen��o B:");
		double b = scanner.nextDouble();
		System.out.println("Digite a Dimen��o C:");
		double c = scanner.nextDouble();

		// Instanciando um Tri�ngulo.
		Triangle triangle = new Triangle(a, b, c);

		if (triangle.isTriangle()) {
			System.out.println("ABC � um Triangulo do tipo: " + triangle.getTipeTriangle() + ".");
		} else {
			System.out.println("ABC n�o � um Triangulo.");
		}

	}

}
