package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.Assalariado;
import br.com.uece.peoo.model.Comissionario;
import br.com.uece.peoo.model.Departamento;
import br.com.uece.peoo.model.Horista;

import java.util.ArrayList;

/**
 * Crie uma classe Main, representando uma empresa. Crie alguns departamentos e alguns
 * funcionários para cada departamento. Execute a folha salarial dos departamentos do mês.
 * Apresente ao final uma lista com o nome dos departamentos e seu valor de folha salarial,
 * ordenado decrescentemente pelo valor da folha.
 */
public class Question11_05 {

    public static ArrayList<Departamento> departamentos;

    public static void main(String[] args) {
        init();

        departamentos.forEach(departamento -> {
            departamento.gerarFolhaSalarial();
            System.out.println();
        });

    }

    /**
     * Inicializando valores.
     */
    public static void init() {
        departamentos = new ArrayList<Departamento>();
        departamentos.add(new Departamento(1, "TI"));
        departamentos.add(new Departamento(2, "RH"));
        departamentos.add(new Departamento(3, "Vendas"));

        departamentos.get(0).addColaborador(new Assalariado(40, "Fulano", 1200));
        departamentos.get(0).addColaborador(new Assalariado(48, "Fulano", 1600));
        departamentos.get(0).addColaborador(new Comissionario(40, "Fulano", 0.1, 20000));
        departamentos.get(0).addColaborador(new Comissionario(40, "Fulano", 0.2, 30000));
        departamentos.get(0).addColaborador(new Horista(40, "Fulano", 30));
        departamentos.get(0).addColaborador(new Horista(40, "Fulano", 30));

        departamentos.get(1).addColaborador(new Assalariado(40, "Fulano", 1200));
        departamentos.get(1).addColaborador(new Assalariado(48, "Fulano", 1600));
        departamentos.get(1).addColaborador(new Comissionario(40, "Fulano", 0.1, 30000));
        departamentos.get(1).addColaborador(new Comissionario(40, "Fulano", 0.15, 20000));
        departamentos.get(1).addColaborador(new Horista(40, "Fulano", 30));
        departamentos.get(1).addColaborador(new Horista(40, "Fulano", 30));

        departamentos.get(2).addColaborador(new Assalariado(40, "Fulano", 1200));
        departamentos.get(2).addColaborador(new Assalariado(48, "Fulano", 1600));
        departamentos.get(2).addColaborador(new Comissionario(40, "Fulano", 0.1, 40000));
        departamentos.get(2).addColaborador(new Comissionario(40, "Fulano", 0.15, 20000));
        departamentos.get(2).addColaborador(new Horista(40, "Fulano", 30));
        departamentos.get(2).addColaborador(new Horista(40, "Fulano", 30));
    }
}
