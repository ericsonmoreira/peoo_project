package lesson_07.questions;

import model.Country;

public class Question_01 {
	public static void main(String[] args) {
		Country BRASIL = new Country("Brasil", "Brasília", 8511000);
		Country vizinhos[] = {
				new Country("Argentina", "Buenos Aires", 2780000),
				new Country("Bolívia", "Sucre", 1099000),
				new Country("Paraguai", "Assunção", 406752)
		};
		for (Country vizinho : vizinhos) {
			BRASIL.addBorderCountrie(vizinho);
		}
		
		
		
	}
}
