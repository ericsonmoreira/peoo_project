package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.MatrizDeInteiros;

import java.util.Arrays;
import java.util.Random;

/**
 * Classe com main que exercita a classe {@link MatrizDeInteiros}.
 */
public class Question11_02 {

    // Inicializando uma Random com semente igal a 100.
    public static Random random = new Random(100);

    // Acho que o nome do método já diz tudo.
    public static void preencerAleatoriamenteMAtriz(MatrizDeInteiros matrizDeInteiros) {
        for (int i = 0; i < matrizDeInteiros.getMatriz().length; i++) {
            for (int j = 0; j < matrizDeInteiros.getMatriz()[i].length; j++) {
                matrizDeInteiros.setElem(i, j, random.nextInt(100));
            }
        }
    }

    public static void main(String[] args) {

        MatrizDeInteiros matrizDeInteiros = new MatrizDeInteiros(15);

        preencerAleatoriamenteMAtriz(matrizDeInteiros);

        matrizDeInteiros.showMatriz();

        System.out.println(matrizDeInteiros.somaTodos());

    }

}
