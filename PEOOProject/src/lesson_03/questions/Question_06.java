package lesson_03.questions;

import util.Question;


/**
 * 6. Receber do usuário uma matriz quadrada (número de linhas = número de colunas) de inteiros e preenchê-la
 * de acordo com os valores informados pelo usuário. Ao final exibir
 * a. a soma dos elementos inseridos na matriz.
 * b. A soma dos elementos da diagonal principal
 * c. Se a matriz é diagonal (todos os elementos são 0, menos os contidos na diagonal principal)
 * d. Qual o maior e o menor elemento da matriz
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question_06 extends Question {


    /**
     * Método para imprimir uma matriz n x n.
     *
     * @param matriz Matriz quadratica de ordem n.
     */
    private static void printMatriz(int[][] matriz) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            String line = "|";
            for (int j = 0; j < n; j++) {
                line += matriz[i][j] + "\t";
            }
            line += "|";
            System.out.println(line);
        }

    }

    /**
     * Método para retornar a soma de todos os elementos da Matriz.
     *
     * @param matriz Matriz quadratica de ordem n.
     * @return Somatório de todos os elementos da matriz.
     */
    private static int sunAll(int[][] matriz) {
        int sun = 0;
        for (int[] line : matriz) {
            for (int cel : line) {
                sun += cel;
            }
        }
        return sun;
    }

    /**
     * Método para retornar a soma dos  elementos da diagonal principal da Matriz.
     *
     * @param matriz Matriz quadratica de ordem n.
     * @return Somatório da diagonal principal da Matriz.
     */
    private static int sunDiagonal(int[][] matriz) {
        int sun = 0;

        for (int i = 0; i < matriz.length; i++) {
            sun += matriz[i][i];
        }
        return sun;
    }

    /**
     * Método para descobrir se a Matriz é Diagonal. Uma Matriz é Diagonal quando todos os
     * elementos são 0, menos os contidos na diagonal principal.
     *
     * @param matriz Matriz quadratica de ordem n.
     * @return <code>true</code> se for uma matriz diagonal, caso contrário, <code>false</code>.
     */
    private static boolean isDiagonalMatriz(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    if (matriz[i][j] == 0) return false;
                } else {
                    if (matriz[i][j] != 0) return false;
                }
            }
        }
        return true;
    }

    /**
     * Método para calcular o menor elemento.
     *
     * @param matriz Matriz quadratica de ordem n.
     * @return menor elemento.
     */
    private static int minElemMatriz(int[][] matriz) {
        int min = matriz[0][0];
        for (int[] line : matriz) {
            for (int elem : line) {
                min = (elem < min) ? elem : min;
            }
        }
        return min;
    }

    /**
     * Método para calcular o maior elemento.
     *
     * @param matriz Matriz quadratica de ordem n.
     * @return maior elemento.
     */
    private static int maxElemMatriz(int[][] matriz) {
        int max = matriz[0][0];
        for (int[] line : matriz) {
            for (int elem : line) {
                max = (elem > max) ? elem : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("Digite o valor de 'n' da Matriz Quadrada M(n x n): ");

        int n = scanner.nextInt();

        int matriz[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Digite o valor de M[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Imprime a matriz
        printMatriz(matriz);

        // a. a soma dos elementos inseridos na matriz.
        System.out.println("******************************************************************");
        System.out.println("Somatório dos elementos: " + sunAll(matriz) + ".");

        // b. A soma dos elementos da diagonal principal.
        System.out.println("******************************************************************");
        System.out.println("Somatório dos elementos da Diagonal Principal: " + sunDiagonal(matriz));

        // c. Se a matriz é diagonal (todos os elementos são 0, menos os contidos na diagonal principal)
        System.out.println("******************************************************************");
        System.out.println("M é uma Matriz Diagonal: " + (isDiagonalMatriz(matriz) ? "Sim." : "Não."));

        // d. Qual o maior e o menor elemento da matriz
        int max = maxElemMatriz(matriz);
        int min = minElemMatriz(matriz);
        System.out.println("******************************************************************");
        System.out.println("Maior elemento de M: " + max + ".");
        System.out.println("Menor elemento de M: " + min + ".");

    }

}
