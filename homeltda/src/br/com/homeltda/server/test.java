package br.com.homeltda.server;

import java.io.IOException;

public class test {

	public static void main(String[] args) {
		try {
			ServidorThread st = new ServidorThread();
			Thread novo = new Thread(st);
			novo.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
