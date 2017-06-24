package Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Business.Usuario;

public class UsuarioDAO extends DerbyDAO{
	
	@Override
	public boolean add(Object usr) {	
		try{
			String sql = "INSERT INTO USUARIO VALUES(?,?,?)";
			PreparedStatement ps  = DerbyDAO.getConnection().prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(((Usuario)usr).getCnpj_cpf()));
			ps.setString(2, ((Usuario) usr).getNome());
			ps.setString(3, ((Usuario) usr).getEmail());		
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){		
			System.out.println("erro na inserção do usuario: "+e.getMessage());
			return false;
		}		
		System.out.println("Usuário inserido com sucesso!");
		return true;
	}

	@Override
	public Object getById(String id){
		for(Object i : this.getContentTable() ){
			if(((Usuario)i).getCnpj_cpf().equals(id)){
				Usuario usuRetur = (Usuario) i;
				return i;		
			}			
		}	return null;
	}

	@Override
	public ArrayList<Object> getContentTable(){

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
			e.printStackTrace();
			return null;
		}

		if(arrayReturn.size() == 0){
			System.out.println("Nenhum registro na tabela USUARIOS");
			return null;
		}else{
			return arrayReturn;
		}
	}
	
	@Override
	public boolean addUser(Object usr) {
		return false;
	}

	public static void main(String[] args){
	}
}