package persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import business.Application;
import business.Categoria;
import business.LeilaoException;
import business.Lote;
import business.Produto;

public class LoteXProduto extends DerbyDAO implements LoteXProdutoDAO {

	private int id;

	public LoteXProduto() throws DaoException {
		this.id = getCurrentId();
	}

	@Override
	public boolean addLoteXProd(int idLote, int idProd) throws DaoException {		
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

	public static void main(String[] args) {
		try {
			Application app = new Application();

			app.getPersistenceFac().executeSQL("SELECT * FROM PRODUTO");
		} catch (DaoException | LeilaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
