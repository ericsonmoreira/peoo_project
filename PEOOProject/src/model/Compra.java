package model;

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
	 * @return Valor final da compra.
	 * 
	 * @param desconto % do desconto.
	 * @return final da compra, após o desconto.
	 */
	public double calcularTotalFinal(double desconto) {
		return calcularTotalCompra() - darDesconto(desconto);
	}
	
	/**
	 * Mostra o cupom fiscal da compra com informação de todos os itens comprado, desconto, tipo de pagamento e valor final e prestações.
	 */
	public void gerarRelatorio() {
		
	}
	
}
