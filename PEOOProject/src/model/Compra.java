package model;

import util.Question;

import java.util.ArrayList;

public class Compra {

    // Itens da compra
    private ArrayList<ItemDeCompra> compraItens;

    public ArrayList<ItemDeCompra> getCompraItens() {
        return compraItens;
    }

    public void setCompraItens(ArrayList<ItemDeCompra> compraItens) {
        this.compraItens = compraItens;
    }

    public Compra() {
        setCompraItens(new ArrayList<ItemDeCompra>());
    }

    /**
     * Insere um item de compra no array.
     *
     * @param itemDeCompra
     */
    public void inserirItem(ItemDeCompra itemDeCompra) {
        this.compraItens.add(itemDeCompra);
    }

    /**
     * Calcula e retorna o valor total da compra.
     *
     * @return
     */
    public double calcularTotalCompra() {
        double total = 0;
        for (ItemDeCompra item : compraItens) {
            total += item.calcularTotal();
        }
        return total;
    }

    /**
     * Recebe como parâmetro a porcentagem de desconto e calcula o valor real do desconto.
     *
     * @param desconto % do desconto
     * @return valor real do desconto
     */
    public double darDesconto(double desconto) {
        return calcularTotalCompra() * desconto;
    }

    /**
     * Retorna o valor final da compra, após o desconto.
     *
     * @param desconto % do desconto.
     * @return final da compra, após o desconto.
     */
    public double calcularTotalFinal(double desconto) {
        return calcularTotalCompra() - darDesconto(desconto);
    }

    /**
     * Exercício:
     * Mostrar o cupom fiscal da compra com informação de todos os itens comprado, desconto, tipo de pagamento e valor final e prestações.
     * Caso a forma de pagamento seja à vista, dar desconto de 10%.
     * Caso seja no crédito, dar desconto de 5%.
     * Pode-se parcelar o valor final em até 3 vezes.
     *
     * @param desconto      Desconto dado
     * @param tipoPagamento Tipo do Pagamento 0 -> A vista e 1 -> a prazo.
     * @param prestacoes    Número de prestações.
     */
    public void gerarRelatorio(double desconto, int tipoPagamento, int numPrestacoes) {

        double valorFinal = 0;
        double valorBruto = this.calcularTotalCompra();
        double prestacao;
        String tipoPagamentoString = (tipoPagamento == 0) ? "A vista" : "A prazo";

        // Cabeçalio
        System.out.println("+------------ Relátorio da Compra ------------+");

        // Imprimindo o conteudo interno
        for (ItemDeCompra item : this.compraItens) {
            double valorUnit = item.getQuant() * item.getPreco();
            System.out.println("--> " + item.getQuant() + " X " + item.getNome() + " = " + Question.numberFormat.format(valorUnit));
        }

        // Gerando o valor com desconto
        valorFinal = calcularTotalFinal(desconto); // Desconto de 10%.
        prestacao = valorFinal / numPrestacoes;
        System.out.println("--> Valor Bruto: " + Question.numberFormat.format(valorBruto));
        System.out.println("--> Valor Final: " + Question.numberFormat.format(valorFinal));
        System.out.println("--> Tipo Pag: " + tipoPagamentoString);
        System.out.println("--> Prestações: " + numPrestacoes + " X " + Question.numberFormat.format(prestacao));
        // Roda-pé
        System.out.println("+-------------------- Fim --------------------+");
    }

}
