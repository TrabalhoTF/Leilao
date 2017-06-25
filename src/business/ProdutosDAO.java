package business;

import java.util.ArrayList;

import business.*;
 
public interface ProdutosDAO {   
	
	// Metodos abstratos para inserir e recuperar dados do BD
	
	boolean adicionarProduto(Produto produto) throws LeilaoException;
	
	Produto getUsuarioPorCpfCnpj(int id_produto) throws LeilaoException;
	
	ArrayList<Produto> getTodosProdutos() throws LeilaoException;

	
}