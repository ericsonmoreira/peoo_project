package util;
import java.util.Scanner;

public class Potencia {

	public static Scanner scanner = new Scanner(System.in);

	public int x;

	public int y;

	/**
	 * 
	 * Construtor.
	 * 
	 * @param x X.
	 * @param y Y.
	 */
	public Potencia(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public static void main(String[] args) {
		System.out.println("Digite o Valor de X:");
		int X = scanner.nextInt();

		System.out.println("Digite o Valor de Y:");
		int Y = scanner.nextInt();

		Potencia potencia = new Potencia(X, Y);

		System.out.println("X ^ Y = " + potencia.elevar());

	}

	/**
	 * 
	 * Método para calcular X ^ Y sem usar {@link Math}.
	 * 
	 * @return X elevado a Y.
	 */
	private int elevar() {
		int aux = 1;
		for (int i = 0; i < y; i++) {
			aux *= x;
		}
		return aux;
	}


}
