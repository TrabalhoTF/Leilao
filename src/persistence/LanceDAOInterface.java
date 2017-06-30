package persistence;

import java.util.ArrayList;

import business.Lance;

public interface LanceDAOInterface {
	
	public boolean add(Lance lance) throws DaoException;

	public Lance getById(int idLance) throws DaoException;

	public ArrayList<Lance> getContentTable() throws DaoException;

}
