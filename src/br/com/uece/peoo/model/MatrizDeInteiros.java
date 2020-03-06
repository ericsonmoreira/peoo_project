package br.com.uece.peoo.model;

import java.util.Arrays;

/**
 * Escreva uma classe chamada “MatrizDeInteiros” que tenha como atributo uma matriz de
 * inteiros e um construtor que receba como parâmetro a ordem da matriz, a instancie e inicialize
 * com zeros. Acrescente a classe os seguintes métodos:
 * a) um método que receba como parâmetro três números inteiros indicando respectivamente
 * linha, coluna e o valor que deve ser armazenado na linha e coluna indicada. Obs: Caso a linha ou
 * a coluna passadas como parâmetro estejam fora da ordem da matriz indique com uma mensagem
 * o erro.
 * b) um método “éQuadrada”, que retorna true se a matriz for quadrada (isto é, tem o mesmo
 * número de linhas e colunas).
 * c) um método total que some todos os valores da matriz retornando o resultado.
 * d) um método que receba como parâmetro um determinado valor e retorne a linha onde o
 * elemento foi encontrado na matriz ou –1 caso contrário.
 * Crie uma classe Main que exercite sua classe MatrizDeInteiros.
 */
public class MatrizDeInteiros {

    private int[][] matriz;

    public int[][] getMatriz() {
        return matriz;
    }

    public MatrizDeInteiros(int n) {
        matriz = new int[n][n];
    }

    /**
     * Seta o valor de um elemento.
     *
     * @param linha numero a linha.
     * @param coluna numero da coluna
     * @param elem valor do elemento.
     */
    public void setElem(int linha, int coluna, int elem) {
        try {
            this.matriz[linha][coluna] = elem;
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Fora da ordem da matriz: " + e.getMessage());
        }
    }

    /**
     * Imprime a matriz.
     */
    public void showMatriz() {
        for (int[] linha: matriz) {
            for (Integer elem: linha) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Verifica se a matriz é quatrática. Uma Matriz eh quantrática quando o nummero de linhas é igual ao
     * numero de colunas. Infelizmente, esse método é redundante, pois se uma {@link MatrizDeInteiros }
     * sempre será N x N, então ela será sempre quadrática. Acho que o professor não percebeu isso ou deve
     * estar pensando numa atualzação da questão para porterior.
     *
     * @return true se for quadrática, false caso contrário.
     *
     */
    public boolean eQuadrada() {
        return matriz.length == matriz[0].length ? true: false;
    }

    /**
     * Soma todos os elementos da matriz.
     *
     * @return Soma de todos elementos da matriz.
     */
    public int somaTodos() {
        return Arrays.stream(matriz).mapToInt(value -> Arrays.stream(value).sum()).sum();
    }

    /**
     * Método que recebe como parâmetro um determinado valor e retorne a linha onde o elemento foi
     * encontrado na matriz ou –1 caso contrário.
     *
     * @param elem valor a ser procurado na matriz.
     * @return linha onde o elemento foi encontrado na matriz ou –1 caso contrário.
     *
     */
    public int linhaDoElemento(int elem) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == elem) return i;
            }
        }
        return -1;
    }
}
