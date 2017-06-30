package persistence;

import java.util.ArrayList;

import business.Leilao;

public interface LeilaoDAOInterface {

		public boolean add(Leilao leilao) throws DaoException;

		public Leilao getById(int id) throws DaoException;

		public ArrayList<Leilao> getContentTable() throws DaoException;
	
}
