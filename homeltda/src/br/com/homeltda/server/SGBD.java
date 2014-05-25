package br.com.homeltda.server;

public class SGBD {
	
	private static SGBD sgbd; 
	private SGBD(){
		
	}
	public static SGBD getInstance(){
		if(sgbd == null)
			sgbd = new SGBD(); 
		return sgbd;
	}
	
}
