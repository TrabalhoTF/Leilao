package persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import business.Categoria;
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
	
	public static void main(String[] args) throws DaoException {
		LoteXProduto s = new LoteXProduto();
		FacadePersistence t = new FacadePersistence();
		
		t.addLote(new Lote(1, 100));
		t.addProd(new Produto(1, Categoria.AUTOMOVEL, "BREVE", "COMPLETA"));
		t.addLoteXProduto(1,1);
		System.out.println(s.getCurrentId());
	}
}
