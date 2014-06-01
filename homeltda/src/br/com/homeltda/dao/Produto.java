package br.com.homeltda.dao;

import java.io.Serializable;

public class Produto implements Serializable{
	private int id;
	private String nome;
	private int qntd;
	private double valorUnitario;
	
	public Produto(int id, String nome, int qntd, double valorUnitario){
		this.id = id;
		this.nome = nome;
		this.qntd = qntd;
		this.valorUnitario = valorUnitario;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario){
		this.valorUnitario = valorUnitario;
	}
	
	
	
}
