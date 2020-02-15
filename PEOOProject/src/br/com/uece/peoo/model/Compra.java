package br.com.uece.peoo.model;

import br.com.uece.peoo.util.JSONable;
import br.com.uece.peoo.util.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Compra extends JSONable {

    // Itens da compra
    private ArrayList<ItemDeCompra> itensDeCompra;

    public ArrayList<ItemDeCompra> getItensDeCompra() {
        return itensDeCompra;
    }

    public void setItensDeCompra(ArrayList<ItemDeCompra> itensDeCompra) {
        this.itensDeCompra = itensDeCompra;
    }

    public Compra() {
        setItensDeCompra(new ArrayList<ItemDeCompra>());
    }

    /**
     * Insere um item de compra no array.
     *
     * @param itemDeCompra
     */
    public void inserirItem(ItemDeCompra itemDeCompra) {
        this.itensDeCompra.add(itemDeCompra);
    }

    /**
     * Calcula e retorna o valor total da compra.
     *
     * @return
     */
    public double calcularTotalCompra() {
        return itensDeCompra.stream().map(ItemDeCompra::calcularTotal).reduce((a, b) -> a + b).get();
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
        itensDeCompra.forEach(item -> System.out.println(item + Question.numberFormat.format(item.calcularTotal())));

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

    @Override
    public String toString() {
        return "Compra{" +
                "itensDeCompra=" + itensDeCompra +
                "}";
    }

    @Override
    protected JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        JSONArray itens = new JSONArray();
        this.itensDeCompra.forEach(a -> itens.add(a.toJSONObject()));
        object.put("itensDeCompra", this.itensDeCompra);
        return object;
    }
}
