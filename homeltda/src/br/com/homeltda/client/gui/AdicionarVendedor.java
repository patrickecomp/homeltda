package br.com.homeltda.client.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class AdicionarVendedor {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JPanel jpCenter;
	private JPanel painelNorte;
	private JComboBox<Vendedor> vendedores;
	private List listaVendedores;
	private JMenuBar menu;
	private Ouvinte ouvinte;
	
	public AdicionarVendedor(Ouvinte ouvinte, List listaVendedores, JMenuBar menu){
		this.listaVendedores = listaVendedores;
		this.menu = menu;
		this.ouvinte = ouvinte;
	}

	public void show() {
		criarJanela();
		criarPainelPrincipal();
		janela.pack();
		janela.setSize(800, 700);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.show();
	}


	private void criarJanela() {
		janela = new JFrame("Home Ltda : Efetuar Venda");
        janela.setJMenuBar(menu);
		
	}

	private void criarPainelPrincipal() {
		painelPrincipal = (JPanel) janela.getContentPane();
		BorderLayout layout = new BorderLayout();
		painelPrincipal.setLayout(layout);
	}

}
