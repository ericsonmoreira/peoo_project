package util;

/**
 * 
 * Classe criada para abistratir um tri�ngulo.
 * 
 * Tr�s dimens�es (A, B, C) conseguem formar um tri�ngulo, quando cada uma dessas 
 * dimens�es, individualmente, for menor que a soma das outras duas dimens�es.
 * 
 * @author Ericson Rogerio Moreira
 *
 */
public class Triangle {
	// Dimens�o A
	private double A;
	
	// Dimens�o B
	private double B;
	
	// Dimens�o C
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
	 * @param a Dimens�o A.
	 * @param b Dimens�o B.
	 * @param c Dimens�o C.
	 * @return <code>true</code> se ABC for um tri�ngulo, caso contr�rio, <code>false</code>.
	 */
	public boolean isTriangle() {
		if (A < (B + C) && B < (A + C) && C < (A + B) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * M�todo para retornar o tipo do tri�ngulo.
	 * 
	 * @param a Dimens�o A.
	 * @param b Dimens�o B.
	 * @param c Dimens�o C.
	 * @return tipo do tri�ngulo.
	 */
	public String getTipeTriangle() {
		String tipeTringle;
		if (A == B && A == C && B == C) { 
			tipeTringle = "Equil�tero";
		} else if (A != B && A != C && B != C) {
			tipeTringle = "Escaleno";
		} else {
			tipeTringle = "Is�sceles";
		}
		return tipeTringle;
	}
}