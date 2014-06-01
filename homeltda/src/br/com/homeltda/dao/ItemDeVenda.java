package br.com.homeltda.dao;


public class ItemDeVenda {
	private Produto item;
	private int qntd;
	
	/**
	 * @return the item
	 */
	public Produto getItem() {
		return item;
	}
	
	/**
	 * @param item the item to set
	 */
	public void setItem(Produto item) {
		this.item = item;
	}
	
	/**
	 * @return the qntd
	 */
	public int getQntd() {
		return qntd;
	}
	
	/**
	 * @param qntd the qntd to set
	 */
	public void setQntd(int qntd) {
		this.qntd = qntd;
	}
	
}
