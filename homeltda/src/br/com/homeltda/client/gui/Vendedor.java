package br.com.homeltda.client.gui;

public class Vendedor {
	
	private String nome;
	private String loja;
	private String cpf;
	
	public Vendedor(String nome, String loja, String cpf){
		this.nome = nome;
		this.loja = loja;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getLoja() {
		return loja;
	}

	public String getCpf() {
		return cpf;
	}
	

}
