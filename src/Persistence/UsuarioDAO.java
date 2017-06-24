package Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Business.Usuario;

public class UsuarioDAO extends DerbyDAO{
	
	@Override
	public boolean addUser(Object usr){		
		try{
			String sql = "INSERT INTO USUARIOS VALUES(?,?,?)";
			PreparedStatement ps  = DerbyDAO.getConnection().prepareStatement(sql);

			ps.setNString(1, ((Usuario) usr).getCnpj_cpf());
			ps.setString(2, ((Usuario) usr).getNome());
			ps.setString(3, ((Usuario) usr).getEmail());		

			ps.execute();
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
			System.out.println(this.getContentTable().get(1));
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
			PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			
		
			//System.out.println(rs.getString(1));

			while(rs.next()){
				arrayReturn.add(new Usuario(rs.getString("CPF_CNPJ"), rs.getString("NOME"), rs.getString("EMAIL")));
				System.out.println(arrayReturn.get(1));
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

		if(arrayReturn.size() == 0){
			System.out.println("Nenhum registro na tabela USUARIOS");
			return null;
		}else{
			System.out.println(arrayReturn.size());
			return arrayReturn;
		}
	}

	public static void main(String[] args) throws SQLException {
		UsuarioDAO u = new UsuarioDAO();
		u.addUser(new Usuario("1", "Teste", "Teste"));

		String sql  =  "SELECT cpf_cnpj FROM USUARIO";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.executeQuery();
		ResultSet rs = ps.getResultSet();
		rs.close();
		ps.close();
	}


}