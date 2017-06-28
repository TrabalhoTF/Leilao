package persistence;

import java.util.ArrayList;

import business.Lote;

public interface LoteDAOInteface {

	public boolean add(Lote lote) throws DaoException;

	public Lote getById(String id) throws DaoException;

	public ArrayList<Lote> getContentTable() throws DaoException;
	
	
}
