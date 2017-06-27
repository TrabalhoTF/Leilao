package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoteXProduto extends DerbyDAO implements LoteXProdutoDAO {

	private int id;
	
	public LoteXProduto() throws DaoException {
		this.id = getCurrentId();
	}

	@Override
	public boolean add(int idLote, int idProd) throws DaoException {		
		try{
			String sql = "INSERT INTO LOTEXPRODUTO VALUES(?,?,?)";
			PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);
			ps.setInt(1, this.getCurrentId());
			ps.setInt(2, idLote);
			ps.setInt(3, idProd);
			ps.executeUpdate();			
			return true;
		}catch(Exception e){
			throw new DaoException("Erro ao inserir a relação entre Lote e Produto, verificar: "+e.getMessage());
		}
	}

	@Override
	public ArrayList<Integer> getById(int idLote, int idProd) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> getContentTab() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getCurrentId() throws DaoException {
		return super.updateCurrentId("LOTEXPRODUTO");
	}
}
