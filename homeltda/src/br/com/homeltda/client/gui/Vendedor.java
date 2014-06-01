package br.com.homeltda.client.gui;

import java.io.Serializable;

public class Vendedor implements Serializable{
	
	private String nome;
	private String rg;
	private String cpf;
	
	public Vendedor(String nome, String rg, String cpf){
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString(){
		return nome;
	}
	
	public String getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}
	

}
