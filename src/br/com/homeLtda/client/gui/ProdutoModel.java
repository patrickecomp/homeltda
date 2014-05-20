package br.com.homeLtda.client.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<String[]> produtos;
	

	public ProdutoModel(List<String[]> produtos, String[] columns) {
		this.produtos = produtos;
		
	}


	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return produtos.get(rowIndex)[columnIndex];
	}

}
