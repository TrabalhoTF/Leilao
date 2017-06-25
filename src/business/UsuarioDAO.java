package business;

import java.util.ArrayList;

import business.*;



public interface UsuarioDAO {   
	
	// metodos abstratos para inserir e recupear dados do BD
	
	boolean adicionarUsuario(Usuario user) throws LeilaoException;
	
	Usuario getUsuarioPorCpfCnpj(int cnpj) throws LeilaoException;
	
	ArrayList<Usuario> getTodosUsuarios() throws LeilaoException;

	
}
