package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Person;
import br.com.uece.peoo.util.Question;

/**
 * Exercício 2
 * Faça um programa que receba o nome e a idade de um 5 pessoas e mostre o nome e a idade da pessoa mais
 * nova e da pessoa mais velha.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question01_02 extends Question {

    /**
     * @param people Lista de {@link Person}.
     * @return {@link Person} com a menor idade.
     */
    private static Person getPersonAgeMin(Person[] people) {

        Person personMinAge = people[0];

        for (int i = 1; i < people.length; i++) {
            if (people[i].getAge() < personMinAge.getAge()) {
                personMinAge = people[i];
            }
        }

        return personMinAge;
    }

    /**
     * @param people Lista de {@link Person}.
     * @return {@link Person} com a maior idade.
     */
    private static Person getPersonAgeMax(Person[] people) {

        Person personMinAge = people[0];

        for (int i = 1; i < people.length; i++) {
            if (people[i].getAge() > personMinAge.getAge()) {
                personMinAge = people[i];
            }
        }

        return personMinAge;
    }

    public static void main(String[] args) {

        // Vetor de pessoas
        Person people[] = new Person[3];

        for (int i = 0; i < people.length; i++) {
            // Pegando o nome da pessoa
            System.out.println("Digite o nome da pessoa " + (i + 1) + ":");
            String name = scanner.next();

            // Pegando a idade da pessoa
            System.out.println("Digite a idade da pessoa " + (i + 1) + ":");
            int age = scanner.nextInt();

            people[i] = new Person(name, age);

        }
        System.out.println("*****************************************************");
        System.out.println("Pessoa mais nova: " + getPersonAgeMin(people) + ".");
        System.out.println("*****************************************************");
        System.out.println("Pessoa mais velha: " + getPersonAgeMax(people) + ".");
        System.out.println("*****************************************************");

    }

}
