package persistence;

import java.util.ArrayList;

import business.Usuario;

public interface UsuarioDAOInterface {
	
	public boolean add(Usuario prod) throws DaoException;

	public Usuario getById(String idProd) throws DaoException;

	public ArrayList<Usuario> getContentTable() throws DaoException;
	

}
