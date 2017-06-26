package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Categoria;
import business.Lote;
import business.Produto;

public class LoteDAO extends DerbyDAO{

	@Override
	public boolean add(Object lote) {
		try{
			String sql = "INSERT INTO LOTE VALUES(?)";
			PreparedStatement ps  = DerbyDAO.getConnection().prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(((Lote)lote).getId_lote()));
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){		
			System.out.println("Erro na inserção do lote: "+e.getMessage());
			return false;
		}		
		System.out.println("Lote inserido com sucesso!");
		return true;
	}

	@Override
	public Object getById(String idLote) {
		for(Object i : this.getContentTable() ){
			if(((Lote)i).getId_lote() == Integer.valueOf(idLote)){
				Lote prodRetur = (Lote) i;
				return i;		
			}			
		}	return null;
	}

	@Override
	public ArrayList<Object> getContentTable() {
		ArrayList<Object> arrayReturn = new ArrayList<>();
		try{
			String sql = "SELECT * FROM LOTE";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();

			while(rs.next()){
//				arrayReturn.add(new Lote(rs.getInt("ID_LOTE"));
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