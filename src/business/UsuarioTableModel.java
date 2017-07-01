package business;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel{

	private List<Usuario> usuarios = new ArrayList<>();
	private String[] colunas = {"Nome", "Cnpj/Cpf","E-mail"};

	@Override
	public String getColumnName (int column){
		return colunas[column];
	}

	public UsuarioTableModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumnCount() {

		return colunas.length;
	}

	@Override
	public int getRowCount() {

		return usuarios.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch(coluna){
		case 0:
			return usuarios.get(linha).getNome();
		case 1:
			return usuarios.get(linha).getCnpj_cpf();
		case 2:
			return usuarios.get(linha).getEmail();
		}
		return null;
	}

	public void addRow(Usuario u){
		this.usuarios.add(u);
		this.fireTableDataChanged();
	}

	public void removeRow(int linha){
		this.usuarios.remove(linha);
		this.fireTableRowsDeleted(linha, linha); 
	}
}