package br.com.homeltda.client.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class ClienteInterface {
	
	private JFrame janela;
	private JPanel PainelPrincipal;
	private List listaVendedores;
	private ConsultarProdutos cp;
	private EfetivarVenda ev;
	private Ouvinte ouvinte;
	
	private void montaTela() {
		
		ouvinte = new Ouvinte(cp, ev);
		ouvinte.start();
		
		carregarVendedores();
		criarJanela();
		criarPainelPrincipal();
		criarImagem();
		janela.pack();
		janela.setSize(598, 378);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	private void carregarVendedores() {
        try {
            FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + File.separator + "vendedores" + File.separator + "vendedores.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            listaVendedores = (List) oi.readObject();
            fi.close();
            oi.close();
        } catch (FileNotFoundException e) {
			listaVendedores = new ArrayList();
        } catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void criarImagem() {
		String URL = System.getProperty("user.dir") + File.separator + "imagens" + File.separator + "Fundo.jpg";
		System.out.println(URL);
		Icon icon = new ImageIcon(URL);
		JLabel result = new JLabel(icon); 
		result.setVisible(true);
		PainelPrincipal.add(result);
		
	}

	private void criarPainelPrincipal() {
		SpringLayout layout = new SpringLayout();
		PainelPrincipal = (JPanel)janela.getContentPane();
		PainelPrincipal.setLayout(layout);
		
	}

	private void criarJanela() {
		janela = new JFrame("Home LTDA");
		
        final JMenuBar menuBar = new JMenuBar();
        JMenu consultar = new JMenu("Sistema");
        JMenu venda = new JMenu("Compra");
        JMenuItem menuItem = new JMenuItem("Consultar produto");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cp = new ConsultarProdutos(ouvinte, menuBar);
				cp.show();
				if(ev != null){
					ev.fechar();
				}
				janela.dispose();
            }
        });

        JMenuItem menuItem2 = new JMenuItem("Efetuar venda");
        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ev = new EfetivarVenda(ouvinte, listaVendedores, menuBar);
				ev.show();
				if(cp != null){
					cp.fechar();
				}
				janela.dispose();
            }
        });
        consultar.add(menuItem);
        venda.add(menuItem2);
        JMenu sair = new JMenu("Sair");
        JMenuItem menuItem4 = new JMenuItem("Sair do sistema");
        menuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        sair.add(menuItem4);
        menuBar.add(consultar);
        menuBar.add(venda);
        menuBar.add(sair);

        janela.setJMenuBar(menuBar);
		
	}
	


	public static void main(String[] args) {
		ClienteInterface ci = new ClienteInterface();
		ci.montaTela();

	}
	
}
