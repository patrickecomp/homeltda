package br.com.homeltda.client.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ouvinte extends Thread{
	
	private Socket socketCliente;
	private Scanner input;
	private Formatter output;
	private ConsultarProdutos cp;
	private EfetivarVenda ev;
	private DataOutputStream outToServer;
	private DataInputStream inputToServer;
	
	public Ouvinte(ConsultarProdutos cp, EfetivarVenda ev) {
		try {
			//conexão com o servidor
			socketCliente = new Socket("localhost", 6525);
			outToServer = new DataOutputStream(socketCliente.getOutputStream());
			inputToServer = new DataInputStream(socketCliente.getInputStream());
			input = new Scanner(socketCliente.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "O servidor está offline.");
			//System.exit(0);
			e.printStackTrace();
		}
		this.cp = cp;
		this.ev = ev;
		

	}
	
	@Override
	public void run(){
		
		while(true){
			if(input.hasNextLine()){
				try {
					processaInformacao(input.nextLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void processaInformacao(String informacao) throws IOException {
		
		if(informacao.equals("0 RESPCONSULTA")){
			inputToServer.readUTF();//falta ainda
		}else{
			if(informacao.equals("1 RESPINSERIR")){
				String mensagem = inputToServer.readUTF();
				if(mensagem.equals("produto existe")){
					JOptionPane.showMessageDialog(null, "Esse produto ja existe.");
				}else{
					JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso.");
				}
			}else{
				if(informacao.equals("4 VENDA")){
					JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso.");
				}
			}
		}
		
	}

	public void pesquisa(String produto) {
		try {
			outToServer.writeUTF("0 CONSULTA");
			outToServer.writeUTF(produto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	
}


