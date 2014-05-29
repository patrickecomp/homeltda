package br.com.homeltda.dao;


import java.util.LinkedList;
import org.joda.time.DateTime;

public class Venda {
	
	private LinkedList<ItemDeVenda> produtos;
	private DateTime dataEHora;
	
	public Venda(){
		produtos = new LinkedList<>();
		dataEHora = new DateTime();
	}
	
	/**
	 * @return the produtos
	 */
	public LinkedList<ItemDeVenda> getProdutos() {
		return produtos;
	}
	
	/**
	 * @param produtos the produtos to set
	 */
	public void addProdutos(ItemDeVenda produtos) {
		this.produtos.add(produtos);
	}
	
	/**
	 * @return the dataEHora
	 */
	public DateTime getDataEHora() {
		return dataEHora;
	}
	
	/**
	 * @param dataEHora the dataEHora to set
	 */
	public void setDataEHora(DateTime dataEHora) {
		this.dataEHora = dataEHora;
	}
	
}
