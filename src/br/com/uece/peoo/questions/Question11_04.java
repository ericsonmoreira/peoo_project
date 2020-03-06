package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Data;

/**
 * Classe com main que instancia duas datas e mostre-as no formato de data, qual a mais antiga e avance-as em
 * um dia, mostrando as novas datas.
 */
public class Question11_04 {

    public static void main(String[] args) {
        // Criando as datas
        Data diaDaIndependencia = new Data(7, 9, 2020);
        Data diaDasMaes = new Data(10, 3, 2010);

        System.out.println("Dia da Independência: " + diaDaIndependencia);
        System.out.println("Dia das Mâes: " + diaDasMaes);

        // Descobrindo qual é mais antida
        if (diaDasMaes.eMaisAntiga(diaDaIndependencia)) {
            System.out.println("Dia das mais mais antigo");
        } else {
            System.out.println("Dia da Independência mais antigo.");
        }

        // Avançando as datas em um dia
        diaDaIndependencia.avancar();
        diaDasMaes.avancar();

        System.out.println("Dia da Independência++: " + diaDaIndependencia);
        System.out.println("Dia das Mâes++: " + diaDasMaes);

    }
}
