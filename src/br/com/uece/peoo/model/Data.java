package br.com.uece.peoo.model;

import java.sql.Struct;
import java.util.regex.Pattern;

/**
 * Crie uma classe para representar datas usando como atributos dia, mês e ano. Crie um construtor que inicializa
 * esses atributos e verifica a validade dos valores fornecidos. Crie os seguintes métodos:
 * a) toString: imprime a data no formato dd/mm/aaaa
 * b) avançar: avança em um dia a data.
 * c) é mais antiga: recebe uma outra data e retorna verdadeiro se a data é mais antiga que a passada por parâmetro
 * ou falso caso contrário.
 * Crie uma classe Main que instancia duas datas e mostre-as no formato de data, qual a mais antiga e avance-as em
 * um dia, mostrando as novas datas.
 */
public class Data {
    // Tudo junto pra ficar mais bonito.
    private int dia, mes, ano;

    public int getDia() {
        return dia;
    }

    /**
     * O dia varia de 1 31.
     *
     * @param dia
     */
    public boolean setDia(int dia) {
        if (dia >= 1 & dia <=31)  {
            this.dia = dia;
            return true;
        }
        return false;
    }

    public int getMes() {
        return mes;
    }

    /**
     * O mês varia de 1 a 12.
     * @param mes
     */
    public boolean setMes(int mes) {
        if (mes >= 1 & mes <= 12){
            this.mes = mes;
            return true;
        }
        return false;
    }

    public int getAno() {
        return ano;
    }

    /**
     * O ano varia de 0 a 9999.
     * @param ano
     */
    public boolean setAno(int ano) {
        if (ano >= 0 & ano <= 9999) {
            this.ano = ano;
            return true;
        }
        return false;
    }

    public Data(int dia, int mes, int ano) {
        // Validações de dia, mês e ano nos devidos sets.
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }

    /**
     *
     * @return
     */
    public boolean avancar() {
        if (!setDia(dia + 1)) { // Tenta mudar o dia
            if (!setMes(mes + 1)) { // Tenta mudar o mes
                if (!setAno(ano + 1)){ // Tenta mudar o ano
                    // Só chega aqui, se a data já for 31/12/9999, que é o máximo.
                    System.err.println("Data execede o máximo.");
                    return false;
                }
                setMes(1); // mês 1 se for aumentar o ano
            }
            setDia(1); // dia é 1 de for aumentar o mês.
        }
        return true;
    }

    /**
     * @param outraData outra {@link Data} para comparar.
     * @return false se a outraData for mais antiga, true caso contrário.
     */
    public boolean eMaisAntiga(Data outraData) {
        // Transoformando das dadas em inteiros.
        int valorData = this.ano * 3 + this.mes * 2  + this.dia;
        int valorOutraData = outraData.getAno() * 3 + outraData.getMes() * 2 + outraData.getDia();
        // se valorData for menor que valorOutraData, então this é mais antiga que outraData.
        return valorData < valorOutraData;
    }

    /**
     * @return String no formato dd/mm/YYYY.
     */
    @Override
    public String toString() {
        /*
         0 depois do percentual é obrigatorio é o numero que vai preencher, o 2 é a quantidade de digitos, varia de
         acordo com a necessidade, e o d informa q é digito, lembrando que o campo id deve ser um Number, Long,
         Integer,etc, não pode estar no formato de String.
         ref: https://www.guj.com.br/t/inserir-zeros-a-esquerda/70374/2
         */
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

//    public static void main(String[] args) {
//        Data data1 = new Data(12, 12, 2010);
//        Data data2 = new Data(13, 12, 2010);
//        for (int i = 0; i < 10000; i++) {
//            data.avancar();
//            System.out.println(data);
//        }
//        System.out.println(data1.eMaisAntiga(data2));
//
//    }

}
