package business;

import java.util.ArrayList;



public interface UsuarioDAO {   
	
	// metodos abstratos para inserir e recupear dados do BD
	
	boolean adicionarUsuario(Usuario user) throws LeilaoException;
	
	Usuario getUsuarioPorCpfCnpj(int cnpj) throws LeilaoException;
	
	ArrayList<Usuario> getTodosUsuarios() throws LeilaoException;

	
}
