package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Usuario;

public class UsuarioDAO extends DerbyDAO{

	@Override
	public boolean add(Object usr) throws DaoException {	
		try{
			String sql = "INSERT INTO USUARIO VALUES(?,?,?)";
			PreparedStatement ps  = DerbyDAO.getConnection().prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(((Usuario)usr).getCnpj_cpf()));
			ps.setString(2, ((Usuario) usr).getNome());
			ps.setString(3, ((Usuario) usr).getEmail());		
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){		
			throw new DaoException("Não foi possível completar a inserção, revisar o objeto informado: "+e.getMessage());
		}		
		System.out.println("Usuário inserido com sucesso!");
		return true;
	}

	@Override
	public Object getById(String idUsu) throws DaoException{
		try{
			for(Object i : this.getContentTable() ){
				if(((Usuario)i).getCnpj_cpf().equals(idUsu)){
					Usuario usuRetur = (Usuario) i;
					return i;	
				}
			}
		}catch(Exception e){
			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: "+e.getMessage());
		}			
		return null;
	}

	@Override
	public ArrayList<Object> getContentTable() throws DaoException{

		ArrayList<Object> arrayReturn = new ArrayList<>();
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

	@Override
	public int getCurrentId() throws DaoException {
		return super.updateCurrentId("USUARIO");
	}
}