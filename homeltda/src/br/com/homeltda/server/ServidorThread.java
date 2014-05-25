package br.com.homeltda.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorThread implements Runnable {

	private ServerSocket servidor; 
	
	public ServidorThread() throws IOException{
		servidor = new ServerSocket(6525);
	}
	
	@Override
	public void run() {

		while(true){
			try {
				Socket socket = servidor.accept();
				criarClienteThread(socket);
			} catch (IOException e) {
				System.out.println("Erro");
			}
		}
	}
	
	public void criarClienteThread(Socket socket){
		ClienteThread cliente = new ClienteThread(socket); 
		Thread t = new Thread(cliente); 
		t.start();
	}

}
