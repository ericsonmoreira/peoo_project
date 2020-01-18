package lesson_03.questions;

import util.Question;


/**
 * 5. Fa�a o algoritmo para calcular e apresentar o valor a ser pago pelo per�odo de estacionamento do autom�vel (PAG). 
 * O usu�rio entra com os seguintes dados: hora (HE) e minuto (ME) de entrada, hora (HS) e minuto (MS) de sa�da. Sabe-se 
 * que esse estacionamento cobra hora cheia, ou seja, se passar um minuto, ele cobra a hora inteira. O valor cobrado 
 * pelo estacionamento �:
 *	-> R$ 5,00 para uma hora de estacionamento;
 *	-> R$ 8,00 para duas horas de estacionamento;
 *	-> R$ 2,00 por hora adicional (acima de duas horas).
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class Question_05 extends Question {

	public static void main(String[] args) {
		// Hora de entrada.
		System.out.println("Digie a Hora de Entrada:");
		int HE = scanner.nextInt();
		
		// Minuto de entrada
		System.out.println("Digie o Minuto de Entrada:");
		int ME = scanner.nextInt();
		
		// Hora de sa�da.
		System.out.println("Digie a Hora de Sa�da:");
		int HS = scanner.nextInt();
		
		// Minuto de sa�da.
		System.out.println("Digie o Minuto de Entrada:");
		int MS = scanner.nextInt();
		
		// Diferen�a em horas convertido em minutos.
		int difH = (HS - HE) * 60;
		System.out.println("difH: " + difH);
		
		// Diferen�a em minutos. 
		int difM = MS - ME;
		System.out.println("difM: " + difM);
		
		// Tempo estacionado em minutos.
		double timeParked = difH - difM;
		System.out.println("timeParked: " + timeParked);
		
		int payment = 0;
		
		if (timeParked <=60) {
			payment += 5;
		} if (timeParked > 60 && timeParked <= 120) {
			payment += 8;
		} else {
			payment += 8 + (int)((timeParked - 120)/60) * 2;
		}
		
		System.out.println("Total a ser pago: " + numberFormat.format(payment) + ".");
		
	}

}
