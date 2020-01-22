package util;
import java.util.Scanner;

/**
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
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

	/**
	 * 
	 * Método para calcular X ^ Y sem usar {@link Math}.
	 * 
	 * @return X elevado a Y.
	 */
	public int elevar() {
		int aux = 1;
		for (int i = 0; i < y; i++) {
			aux *= x;
		}
		return aux;
	}


}
