package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Usuario;

public class UsuarioDAO extends DerbyDAO implements UsuarioDAOInterface{ 

	@Override
	public boolean add(Usuario usr) throws DaoException {	
		try{
			String sql = "INSERT INTO USUARIO VALUES(?,?,?)";
			PreparedStatement ps  = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println(usr.toString());
			ps.setInt(1, Integer.valueOf(usr.getCnpj_cpf()));
			ps.setString(2, usr.getNome());
			ps.setString(3, usr.getEmail());		
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){		
			throw new DaoException("Não foi possível completar a inserção, revisar o objeto informado: "+e.getMessage());
		}		
		System.out.println("Usuário inserido com sucesso!");
		return true;
	}

	@Override
	public Usuario getById(String idUsu) throws DaoException{
		try{
			for(Usuario i : this.getContentTable() ){
				if(i.getCnpj_cpf().equals(idUsu)){
					Usuario usuRetur = i;
					return i;	
				}
			}
		}catch(Exception e){
			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: "+e.getMessage());
		}			
		return null;
	}

	@Override
	public ArrayList<Usuario> getContentTable() throws DaoException{

		ArrayList<Usuario> arrayReturn = new ArrayList<>();
		try{
			String sql = "SELECT * FROM USUARIO";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();

			while(rs.next()){
				arrayReturn.add(new Usuario(rs.getString("CPF_CNPJ"), rs.getString("NOME"), rs.getString("EMAIL")));
			}
		}catch(SQLException e){
			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: "+e.getMessage());
		}

		if(arrayReturn.size() == 0){
			System.out.println("Nenhum registro na tabela USUARIOS");
			return null;
		}else{
			return arrayReturn;
		}
	}

}