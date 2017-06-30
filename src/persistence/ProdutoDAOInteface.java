package persistence;

import java.util.ArrayList;

import business.Lote;
import business.Produto;

public interface ProdutoDAOInteface {

	public boolean add(Produto prod) throws DaoException;

	public Produto getById(int idProd) throws DaoException;

	public ArrayList<Produto> getContentTable() throws DaoException;
	
	
}
