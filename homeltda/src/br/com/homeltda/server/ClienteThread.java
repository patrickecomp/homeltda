package br.com.homeltda.server;

import java.net.Socket;

public class ClienteThread implements Runnable {

	private Socket socket; 
	public ClienteThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
