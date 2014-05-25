package br.com.homeltda.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread implements Runnable {

	private Socket socket; 
	private SGBD sgbd; 
	
	public ClienteThread(Socket socket) {
		this.socket = socket;
		sgbd = SGBD.getInstance();
	}

	@Override
	public void run() {
	
	}
	
	public String[] lerRequisicao() throws IOException{
		
		InputStreamReader isReader = new InputStreamReader(socket.getInputStream()); 
		BufferedReader bReader = new BufferedReader(isReader); 
		String line;
		String [] requisicao = null;
		
		if((line = bReader.readLine()) != null){
			requisicao = line.split(" ");
		}
		return requisicao;
	}
	
	public String getValues() throws IOException{
		
		String values = ""; 
		InputStreamReader isReader = new InputStreamReader(socket.getInputStream()); 
		BufferedReader bReader = new BufferedReader(isReader); 
		String line;
		while((line = bReader.readLine()) != null){
			values += line;
		}
		return values; 
	}
	
	public void solicitarOperacao(String [] request ){
		
	}

}
