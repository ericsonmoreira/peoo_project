package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Pais;


/**
 * 1. Escreva uma classe que represente um país. Um país tem como atributos o	seu nome, o nome da capital, sua dimensão em Km2
 * e uma lista de países com os quais ele faz fronteira. Represente a classe e forneça os seguintes construtores e métodos:
 * a) Construtor que inicialize o nome, capital e a dimensão do país.
 * b) Métodos de	acesso	(get e set) para as propriedades indicadas no item (a).
 * c) Um	 método que permita verificar se dois países são iguais. Dois países são iguais se tiverem o mesmo nome e a mesma
 * capital. A assinatura deste método deve ser: public boolean equals (Pais outro)
 * d) Um	método que define quais outros países fazem fronteira (note que um país não pode	fazer fronteira com ele mesmo)
 * e) Um	método que retorne o nome e a capital dos países que fazem fronteira
 * <p>
 * Crie uma classe Main para exercitar sua classe País
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question06_01 {
    public static void main(String[] args) {
        Pais BRASIL = new Pais("Brasil", "Brasília", 8511000);
        Pais vizinhos[] = {
                new Pais("Argentina", "Buenos Aires", 2780000),
                new Pais("Bolívia", "Sucre", 1099000),
                new Pais("Paraguai", "Assunção", 406752)
        };
        BRASIL.addBorderCountrie(new Pais("Argentina", "Buenos Aires", 2780000));

        for (Pais vizinho : vizinhos) {
            BRASIL.addBorderCountrie(vizinho);
        }

        try {
            // Tentando passar o Brasil como vizinho do Brasil
            BRASIL.addBorderCountrie(BRASIL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(BRASIL.toStringJSON());

        BRASIL.getCountryNameForCapital().keySet().forEach(
                key -> System.out.println("Pais:" + key + ", Capital: " + BRASIL.getCountryNameForCapital().get(key)));

    }
}
