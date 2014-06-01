package br.com.homeltda.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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

public class ConsultarProdutos {
		
	private JFrame frame; 
	private JPanel jpMain; 
	private JPanel jpCenter; 
	private JPanel jpHeader; 
	private JPanel jpFooter; 
	private JMenuBar menu;
	private Ouvinte ouvinte;
	private JTextField txtSearch;
	
	public ConsultarProdutos(Ouvinte ouvinte, JMenuBar menuBar) {
		menu = menuBar;
		this.ouvinte = ouvinte;
	}

	public void show(){
		createFrame();
		createJpMain();
		createJpHeader();
		createJpCenter();
		frame.setJMenuBar(menu);
		frame.pack();
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.show();
	}
	
	private void createFrame(){
		frame = new JFrame("Home Ltda : Consulta de Produtos");
	}
	
	private void createJpMain(){
		jpMain = (JPanel) frame.getContentPane();
		BorderLayout layout = new BorderLayout(); 
		jpMain.setLayout(layout);
	}
	
	private void createJpHeader(){
		GridLayout  grid = new GridLayout(2, 1);
		jpHeader = new JPanel(grid);
		
		Font font = new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 16);
		JLabel lblLogo = new JLabel("Home Ltda");
		lblLogo.setFont(font);
		
		JPanel jpSearch = createJpSearch(font);
		
		jpHeader.add(lblLogo); 
		jpHeader.add(jpSearch);
		
		jpMain.add(jpHeader, BorderLayout.NORTH);
	}

	private JPanel createJpSearch(Font font) {
		
		JPanel jpSearch = new JPanel(); 
		BoxLayout box = new BoxLayout(jpSearch, BoxLayout.X_AXIS); 
		jpSearch.setLayout(box);
		
		JLabel lblSearch = new JLabel("Codigo:");
		lblSearch.setFont(font);
		
		
		txtSearch = new JTextField(40);
		txtSearch.setFont(font);
		// add event
		
		JButton btnSearch = new JButton("Pesquisar");
		btnSearch.setFont(font);
		btnSearch.addActionListener(new SearchListener());
		
		Dimension d = new Dimension(30,30);
		jpSearch.add(Box.createRigidArea(d));
		jpSearch.add(lblSearch);
		jpSearch.add(Box.createRigidArea(d));
		jpSearch.add(txtSearch); 
		jpSearch.add(Box.createRigidArea(d));
		jpSearch.add(btnSearch);
		jpSearch.add(Box.createRigidArea(d));
		

		return jpSearch;
	}

	private void createJpCenter(){
		
		SpringLayout layout = new SpringLayout();
		jpCenter = new JPanel(layout); 
		Font font = new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 16);
	
		JScrollPane scroll = createScroll(font);
		createTable(font, scroll);  
		
		jpCenter.add(scroll);
		
		layout.putConstraint(SpringLayout.WEST, scroll, 25, SpringLayout.WEST, jpCenter);
		layout.putConstraint(SpringLayout.NORTH, scroll, 25, SpringLayout.NORTH, jpCenter);
		layout.putConstraint(SpringLayout.EAST, scroll, -25, SpringLayout.EAST, jpCenter);
		layout.putConstraint(SpringLayout.SOUTH, scroll, -25, SpringLayout.SOUTH, jpCenter);
		
		jpMain.add(jpCenter, BorderLayout.CENTER);
	}
	
	private void createTable(Font font, JScrollPane scroll) {
		
		JTable table = new JTable(); 
		String [] values = {"004", "ULTRABOOK SAMSUNG", "1", "2,045.99"};
		String [] columns = {"COD", "DESCRICAO", "QTD", "PREÇO UNIT."};
		List<String[]> model = new ArrayList<>(); 
		for(int i = 0; i < 10; i++){
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

	private class SearchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(txtSearch.getText().trim() == ""){
				JOptionPane.showMessageDialog(null, "O campo esta em branco!");
			}else{
				ouvinte.pesquisa(txtSearch.getText().trim());
			}
			
			
		}
		
	}

	public void fechar() {
		frame.dispose();
		
	}
	
	

}
