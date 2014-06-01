package br.com.homeltda.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

public class EfetivarVenda {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JPanel jpCenter;
	private JPanel painelNorte;
	private JComboBox<Vendedor> vendedores;
	private List listaVendedores;
	private JMenuBar menu;
	private Ouvinte ouvinte;
	
	public EfetivarVenda(Ouvinte ouvinte, List listaVendedores, JMenuBar menu){
		this.listaVendedores = listaVendedores;
		this.menu = menu;
		this.ouvinte = ouvinte;
	}

	public void show() {
		criarJanela();
		criarPainelPrincipal();
		criarPainelNorte();
		criarPainelCentro();
		criarPainelSul();
		janela.pack();
		janela.setSize(800, 700);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.show();
	}

	private void criarPainelSul() {
		JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton adiciona = new JButton("Adicionar produto");
		adiciona.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				String produto = JOptionPane.showInputDialog("Digite o nome do produto: ");
				String quantidade = JOptionPane.showInputDialog("Digite a quantidade: ");
				
				ouvinte.pesquisa(produto);
				//continuação..
			}
		});
		JButton finalizar = new JButton("Finalizar compra");
		finalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				
			}
		});
		flow.add(adiciona);
		flow.add(finalizar);
		painelPrincipal.add(flow, BorderLayout.SOUTH);
		
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

	private void criarPainelNorte() {
		painelNorte = new JPanel();
		BoxLayout layout = new BoxLayout(painelNorte, BoxLayout.Y_AXIS);
		painelNorte.setLayout(layout);
		JPanel vendedor = criarPainelVendedor();
		JPanel cliente = criarPainelCliente();
		JPanel lojaCpf = criarPainelLoja();

		painelNorte.add(vendedor);
		painelNorte.add(cliente);
		painelNorte.add(lojaCpf);

		painelPrincipal.add(painelNorte, BorderLayout.NORTH);
	}

	private JPanel criarPainelLoja() {
		JPanel painelLoja = new JPanel(new GridLayout(1, 2));
		JPanel parteLoja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel loja = new JLabel("Nome da loja:       ");
		JTextField lojaTxt = new JTextField(15);
		parteLoja.add(loja);
		parteLoja.add(lojaTxt);
		
		JPanel parteCPF = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel cpf = new JLabel("Digite o CPF do cliente: ");
		JTextField cpfTxt = new JTextField(15);
		parteCPF.add(cpf);
		parteCPF.add(cpfTxt);
		
		painelLoja.add(parteLoja);
		painelLoja.add(parteCPF);
		return painelLoja;
	}

	private JPanel criarPainelCliente() {
		JPanel painelCliente = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel cliente = new JLabel("Nome do cliente: ");
		JTextField nome = new JTextField(25);
		painelCliente.add(cliente);
		painelCliente.add(nome);
		return painelCliente;
	}

	private JPanel criarPainelVendedor() {
		JPanel vendedor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelVendedor = new JLabel("Escolha o vendedor: ");
		vendedores = new JComboBox<Vendedor>();
		vendedores.removeAllItems();
		Iterator it = listaVendedores.iterator();
		while(it.hasNext()){
			Vendedor atual = (Vendedor)it.next();
			vendedores.addItem(atual);
		}
		vendedor.add(labelVendedor);
		vendedor.add(vendedores);

		return vendedor;
	}


	private void criarPainelCentro() {

		SpringLayout layout = new SpringLayout();
		jpCenter = new JPanel(layout);
		Font font = new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 16);

		JScrollPane scroll = createScroll(font);
		createTable(font, scroll);

		jpCenter.add(scroll);

		layout.putConstraint(SpringLayout.WEST, scroll, 25, SpringLayout.WEST,
				jpCenter);
		layout.putConstraint(SpringLayout.NORTH, scroll, 25,
				SpringLayout.NORTH, jpCenter);
		layout.putConstraint(SpringLayout.EAST, scroll, -25, SpringLayout.EAST,
				jpCenter);
		layout.putConstraint(SpringLayout.SOUTH, scroll, -25,
				SpringLayout.SOUTH, jpCenter);

		painelPrincipal.add(jpCenter, BorderLayout.CENTER);
	}

	private void createTable(Font font, JScrollPane scroll) {

		JTable table = new JTable();
		String[] values = { "004", "ULTRABOOK SAMSUNG", "1", "2,045.99" };
		String[] columns = { "COD", "DESCRICAO", "QTD", "PREÃ‡O UNIT." };
		List<String[]> model = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			model.add(values);
		}
		ProdutoModel topicModel = new ProdutoModel(model, columns);
		table.setModel(topicModel);
		topicModel.addTableModelListener(table);
		table.setBorder(new LineBorder(Color.black));
		table.setGridColor(Color.black);
		table.setShowGrid(true);
		table.setFont(font);
		table.setRowHeight(30);
		scroll.setViewportView(table);
	}

	private JScrollPane createScroll(Font font) {

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBorder(null);
		scroll.getViewport().setSize(70, 70);
		scroll.setFont(font);
		scroll.setVisible(true);

		return scroll;
	}
	
	public void fechar() {
		janela.dispose();
		
	}


}
