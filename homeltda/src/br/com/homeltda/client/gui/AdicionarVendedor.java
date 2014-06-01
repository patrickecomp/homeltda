package br.com.homeltda.client.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AdicionarVendedor {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JMenuBar menu;
	private ClienteInterface ci;
	
	public AdicionarVendedor(ClienteInterface ci, JMenuBar menuBar) {
		menu = menuBar;
		this.ci = ci;
	}

	public void montarTela() {
		criarJanela();
		criarPainelPrincipal();
		criarTela();
		janela.pack();
		janela.setSize(450, 190);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.show();
	}


	private void criarTela() {
		SpringLayout spring = new SpringLayout();
		JPanel painelDados = new JPanel(spring);
		
		JLabel nome = new JLabel("Nome completo: ");
		final JTextField nomeTxt = new JTextField(25);
		JLabel cpf = new JLabel("Digite o CPF: ");
		final JTextField cpfTxt = new JTextField(20);
		JLabel rg = new JLabel("Digite o RG: ");
		final JTextField rgTxt = new JTextField(20);
		
		painelDados.add(nome);
		painelDados.add(nomeTxt);
		painelDados.add(cpf);
		painelDados.add(cpfTxt);
		painelDados.add(rg);
		painelDados.add(rgTxt);
		
		spring.putConstraint(SpringLayout.WEST, nomeTxt, 100, SpringLayout.WEST, painelDados);
		spring.putConstraint(SpringLayout.NORTH, cpfTxt, 25, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.WEST, cpfTxt, 100, SpringLayout.WEST, painelDados);
		spring.putConstraint(SpringLayout.NORTH, cpf, 25, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.NORTH, rgTxt, 50, SpringLayout.NORTH, painelDados);
		spring.putConstraint(SpringLayout.WEST, rgTxt, 100, SpringLayout.WEST, painelDados);
		spring.putConstraint(SpringLayout.NORTH, rg, 50, SpringLayout.NORTH, painelDados);
		
		painelPrincipal.add(painelDados, BorderLayout.CENTER);
		
		JButton criarVendedor = new JButton("Cadastrar Vendedor");
		criarVendedor.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent event) {
				ci.adicionaVendedor(nomeTxt.getText().trim(), cpfTxt.getText().trim(), rgTxt.getText().trim());
				nomeTxt.setText("");
				cpfTxt.setText("");
				rgTxt.setText("");
				JOptionPane.showMessageDialog(null, "O vendedor foi cadastrado com sucesso!");
			}
		});
		
		JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		flow.add(criarVendedor);
		painelPrincipal.add(flow, BorderLayout.SOUTH);
		
	}

	private void criarJanela() {
		janela = new JFrame("Home Ltda : Adicionar Vendedor");
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
