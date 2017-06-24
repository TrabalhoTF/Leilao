package Persistence;

import java.util.ArrayList;

import Business.LeilaoException;
import Business.Produto;
 
public interface ProdutosDAO {   
	
	// Metodos abstratos para inserir e recuperar dados do BD
	
	boolean adicionarProduto(Produto produto) throws LeilaoException;
	
	Produto getUsuarioPorCpfCnpj(int id_produto) throws LeilaoException;
	
	ArrayList<Produto> getTodosProdutos() throws LeilaoException;

	
}