package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LoteXProdutoDAO{
	
	public boolean addLoteXProd(int idLote, int idProd) throws DaoException;

	public ArrayList<Integer> getById(int idLote, int idProd) throws DaoException;

	public ArrayList<Integer> getContentTab() throws DaoException;
	

}
