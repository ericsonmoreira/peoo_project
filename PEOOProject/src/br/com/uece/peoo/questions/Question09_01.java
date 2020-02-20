package br.com.uece.peoo.questions;

import br.com.uece.peoo.model.*;
import br.com.uece.peoo.util.Question;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 5. Crie uma classe Principal no qual vários canais são criados. Em seguida, crie pelo menos 3
 * TVs (uma de cada tipo), e cadastre os canais criados. Crie um objeto do controle remoto,
 * associe a ele as TVs criadas, e ofereça ao usuário um menu com as opções disponíveis. Toda
 * vez que o usuário escolhe uma opção, o método correspondente nas TVs é executado.
 */
public class Question09_01 extends Question {

    public static ArrayList<Canal> canais;

    public static ArrayList<Televisao> tvs;

    public static ControleRemoto controleRemoto;

    public static void main(String[] args) {
        init();
        menu();
    }

    /**
     * Instanciando Objetos.
     */
    private static void init(){
        // lista de canais
        canais = new ArrayList<Canal>();
        canais.add(new Canal(5, "SBT", false));
        canais.add(new Canal(51, "SBT HD", true));
        canais.add(new Canal(20, "Globo News", false));
        canais.add(new Canal(201, "Globo News HD",true));
        canais.add(new Canal(35, "Tv União", false));
        canais.add(new Canal(351, "Tv União HD", true));
        canais.add(new Canal(100, "History Channel", false));
        canais.add(new Canal(1001, "History Channel HD", true));
        canais.add(new Canal(120, "HBO", false));
        canais.add(new Canal(1201, "HBO HD", true));

        // lisa de Tvs
        tvs = new ArrayList<Televisao>();
        tvs.add(new Televisao("Semp1951", 0, canais.get(0)));
        tvs.add(new SmartTV("SamsungUN65RU7100", 10, canais.get(1), 65));
        tvs.add(new TVHD("PhilcoPTV32",1, canais.get(2),  TVHD.MODELO.HD));

        // Controle Remoto
        controleRemoto = new ControleRemoto();
        controleRemoto.setTelevisores(tvs);

        // Tentando cadastrar todos os canais nas TVs.
        tvs.forEach(tv -> tv.cadastrarCanais(canais));
    }

    private static void menu() {
        // Loop infinito.
        while (true) {
            int opition = printMenu();
            switch (opition) {
                case 1: // Informar os Dados
                    controleRemoto.informarDados();
                    break;
                case 2: // Aumentar Volume
                    controleRemoto.aumentarVolume();
                    break;
                case 3: // Diminuir Volume.
                    controleRemoto.diminuirVolume();
                    break;
                case 4: // Proximo Canal.
                    controleRemoto.proximoCanal();
                    break;
                case 5: // Canal Anterior.
                    controleRemoto.canalAnterior();
                    break;
                case 6: // Mostrar Grade.
                    controleRemoto.mostrarGrade();
                    break;
                case 99: // Fechar programa
                default:
                    System.err.println("Opção Invalida!");
            }
        }
    }

    private static int printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------- Menu ---------------------");
        System.out.println("1 --> Informar Dados.");
        System.out.println("2 --> + Volume.");
        System.out.println("3 --> - Volume.");
        System.out.println("4 --> >> Canal.");
        System.out.println("5 --> << Canal.");
        System.out.println("6 --> Mostrar Grade.");
        System.out.println("99 --> Fechar Programa.");
        System.out.println("Digite a opção: ");
        int option = scanner.nextInt();
        return option; // Retorna a opção digitada.
    }

}
