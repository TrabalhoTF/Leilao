package persistence;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Categoria;
import business.Produto;

public class ProdutoDAO extends DerbyDAO implements ProdutoDAOInteface {

	@Override
	public boolean add(Produto prod) throws DaoException {	
		try{
			String sql = "INSERT INTO PRODUTO VALUES(?,?,?,?)";
			PreparedStatement ps  = DerbyDAO.getConnection().prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(prod.getId_produto()));
			ps.setString(2, String.valueOf(prod.getCateg().name()));
			ps.setString(3, (prod.getDescBreve()));
			ps.setString(4, (prod.getDescCompleta()));
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){		
			throw new DaoException("Não foi possível completar a inserção, revisar o objeto informado: "+e.getMessage());
		}		
		System.out.println("Produto inserido com sucesso!");
		return true;
	}

	@Override
	public Produto getById(String idProd){
		for(Produto i : this.getContentTable() ){
			if(i.getId_produto() == Integer.valueOf(idProd)){
				Produto prodRetur =  i;
				return i;		
			}			
		}	return null;
	}

	@Override
	public ArrayList<Produto> getContentTable(){
		ArrayList<Produto> arrayReturn = new ArrayList<>();
		try{
			String sql = "SELECT * FROM PRODUTO";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();

			while(rs.next()){
				arrayReturn.add(new Produto(rs.getInt("ID_PRODUTO"), 
						Categoria.valueOf(rs.getString("CATEGORIA")),
						rs.getString("DESCRICAO_SIMPLES"),
						rs.getString("DESCRICAO_COMPLETA")));
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

		if(arrayReturn.size() == 0){
			System.out.println("Nenhum registro na tabela PRODUTO");
			return null;
		}else{
			return arrayReturn;
		}
	}

}