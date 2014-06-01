package br.com.homeltda.client.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AdicionarProduto {
	private JFrame janela;
	private JPanel painelPrincipal;
	private JMenuBar menu;
	private Ouvinte ouvinte;
	
	public AdicionarProduto(Ouvinte ouvinte, JMenuBar menuBar) {
		menu = menuBar;
		this.ouvinte = ouvinte;
	}

	public void montarTela() {
		criarJanela();
		criarPainelPrincipal();
		criarTela();
		janela.pack();
		janela.setSize(450, 210);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.show();
	}


	private void criarTela() {
		SpringLayout spring = new SpringLayout();
		JPanel painelDados = new JPanel(spring);
		
		JLabel id = new JLabel("Id do produto: ");
		final JTextField idTxt = new JTextField(20);
		JLabel nome = new JLabel("Nome do produto: ");
		final JTextField nomeTxt = new JTextField(25);
		JLabel qntd = new JLabel("Quantidade: ");
		final JTextField qntdTxt = new JTextField(10);
		JLabel valor = new JLabel("Valor unitario: ");
		final JTextField valorTxt = new JTextField(10);
		
		painelDados.add(id);
		painelDados.add(idTxt);
		painelDados.add(nome);
		painelDados.add(nomeTxt);
		painelDados.add(qntd);
		painelDados.add(qntdTxt);
		painelDados.add(valor);
		painelDados.add(valorTxt);
		
		spring.putConstraint(SpringLayout.WEST, idTxt, 120, SpringLayout.WEST, painelDados);
		spring.putConstraint(SpringLayout.NORTH, nomeTxt, 25, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.WEST, nomeTxt, 120, SpringLayout.WEST, painelDados);
		spring.putConstraint(SpringLayout.NORTH, nome, 25, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.NORTH, qntdTxt, 50, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.WEST, qntdTxt, 120, SpringLayout.WEST, painelDados);
		spring.putConstraint(SpringLayout.NORTH, qntd, 50, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.NORTH, valor, 75, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.NORTH, valorTxt, 75, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.WEST, valorTxt, 120, SpringLayout.WEST, painelDados);
		
		painelPrincipal.add(painelDados, BorderLayout.CENTER);
		
		JButton criarVendedor = new JButton("Cadastrar Produto");
		criarVendedor.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent event) {
				ouvinte.adicionaProduto(idTxt.getText().trim(), nomeTxt.getText().trim(), qntdTxt.getText().trim(), valorTxt.getText().trim());
			}
		});
		
		JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		flow.add(criarVendedor);
		painelPrincipal.add(flow, BorderLayout.SOUTH);
		
	}

	private void criarJanela() {
		janela = new JFrame("Home Ltda : Adicionar Produto");
        janela.setJMenuBar(menu);
		
	}

	private void criarPainelPrincipal() {
		painelPrincipal = (JPanel) janela.getContentPane();
		BorderLayout layout = new BorderLayout();
		painelPrincipal.setLayout(layout);
	}

	public void fechar() {
		janela.dispose();
	}

}
