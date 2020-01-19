package util;

/**
 * 
 * Classe criada para abistratir um triângulo.
 * 
 * Três dimensões (A, B, C) conseguem formar um triângulo, quando cada uma dessas 
 * dimensões, individualmente, for menor que a soma das outras duas dimensões.
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class Triangle {
	// Dimensão A
	private double A;
	
	// Dimensão B
	private double B;
	
	// Dimensão C
	private double C;

	public double getA() {
		return A;
	}

	public void setA(double a) {
		A = a;
	}

	public double getB() {
		return B;
	}

	public void setB(double b) {
		B = b;
	}

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}
	
	public Triangle(double a, double b, double c) {
		this.setA(a);
		this.setB(b);
		this.setC(c);
	}
	
	/**
	 * 
	 * @param a Dimensão A.
	 * @param b Dimensão B.
	 * @param c Dimensão C.
	 * @return <code>true</code> se ABC for um triângulo, caso contrário, <code>false</code>.
	 */
	public boolean isTriangle() {
		if (A < (B + C) && B < (A + C) && C < (A + B) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Método para retornar o tipo do triângulo.
	 * 
	 * @param a Dimensão A.
	 * @param b Dimensão B.
	 * @param c Dimensão C.
	 * @return tipo do triângulo.
	 */
	public String getTipeTriangle() {
		String tipeTringle;
		if (A == B && A == C && B == C) { 
			tipeTringle = "Equilátero";
		} else if (A != B && A != C && B != C) {
			tipeTringle = "Escaleno";
		} else {
			tipeTringle = "Isósceles";
		}
		return tipeTringle;
	}
}