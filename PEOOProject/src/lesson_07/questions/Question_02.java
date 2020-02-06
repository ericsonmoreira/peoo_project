package lesson_07.questions;

/**
 * 2. Crie uma classe ItemDeCompra que representa um item de uma compra numa loja de suprimentos de informática.
 * Cada item de compra tem um código, o nome do produto, o preço unitário e a quantidade comprada. Crie um construtor
 * que inicialize esses atributos e métodos de get e set para cada atributo. Crie também um método calcularTotal que
 * devolve o valor total pago pelo item (preço unitátio * quantidade). Crie uma classe Compra que possui um array de
 * itens de venda (por simplicidade, considere que uma compra possui no máximo 5 itens). Crie os seguintes métodos:
 * a)	inserirItem: insere um item de compra no array
 * b)	calcularTotalCompra: calcula e retorna o valor total da compra
 * c)	darDesconto: recebe como parâmetro a porcentagem de desconto e calcula o valor real do desconto
 * d)	calcularTotalFinal: retorna o valor final da compra, após o desconto.
 * e)	gerarRelatório: mostra o cupom fiscal da compra com informação de todos os itens comprado, desconto,
 * tipo de pagamento e valor final e prestações.
 * <p>
 * Faça uma classe Main que simule uma registradora de um ponto de venda da loja. Ela registra a compra de vários produtos
 * da loja. Caso a forma de pagamento seja à vista, dar desconto de 10%. Caso seja no crédito, dar desconto de 5% e  pode-se
 * parcelar o valor final em até 3 vezes, Ao final da compra, imprima o cupom fiscal para o usuário.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Question_02 {

    // Não sabia que podia fazer isso!!!
    public static void print(String... palavras) {
        for (String palavra : palavras) System.out.println(palavra);
    }

    public static void main(String[] args) {
        print("Ola", "mundo", "!");
    }

}
