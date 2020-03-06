package br.com.uece.peoo.questions;

import br.com.uece.peoo.util.Question;


/**
 * 5. Faça o algoritmo para calcular e apresentar o valor a ser pago pelo período de estacionamento do automóvel (PAG).
 * O usuário entra com os seguintes dados: hora (HE) e minuto (ME) de entrada, hora (HS) e minuto (MS) de saída. Sabe-se
 * que esse estacionamento cobra hora cheia, ou seja, se passar um minuto, ele cobra a hora inteira. O valor cobrado
 * pelo estacionamento é:
 * -> R$ 5,00 para uma hora de estacionamento;
 * -> R$ 8,00 para duas horas de estacionamento;
 * -> R$ 2,00 por hora adicional (acima de duas horas).
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question02_05 extends Question {

    public static void main(String[] args) {
        // Hora de entrada.
        System.out.println("Digie a Hora de Entrada:");
        int HE = scanner.nextInt();

        // Minuto de entrada
        System.out.println("Digie o Minuto de Entrada:");
        int ME = scanner.nextInt();

        // Hora de saída.
        System.out.println("Digie a Hora de Saída:");
        int HS = scanner.nextInt();

        // Minuto de saída.
        System.out.println("Digie o Minuto de Entrada:");
        int MS = scanner.nextInt();

        // Diferença em horas convertido em minutos.
        int difH = (HS - HE) * 60;
        System.out.println("difH: " + difH);

        // Diferença em minutos.
        int difM = MS - ME;
        System.out.println("difM: " + difM);

        // Tempo estacionado em minutos.
        double timeParked = difH - difM;
        System.out.println("timeParked: " + timeParked);

        int payment = 0;

        if (timeParked <= 60) {
            payment += 5;
        }
        if (timeParked > 60 && timeParked <= 120) {
            payment += 8;
        } else {
            payment += 8 + (int) ((timeParked - 120) / 60) * 2;
        }

        System.out.println("Total a ser pago: " + numberFormat.format(payment) + ".");

    }

}
