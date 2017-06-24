package Business;

import java.util.ArrayList;
 
public interface ProdutosDAO {   
	
	// Metodos abstratos para inserir e recuperar dados do BD
	
	boolean adicionarProduto(Produto produto) throws LeilaoException;
	
	Produto getUsuarioPorCpfCnpj(int id_produto) throws LeilaoException;
	
	ArrayList<Produto> getTodosProdutos() throws LeilaoException;

	
}