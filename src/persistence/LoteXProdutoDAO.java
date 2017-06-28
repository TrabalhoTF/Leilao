package persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import business.Categoria;
import business.Lote;
import business.Main;
import business.Produto;
import business.Usuario;

public class LoteXProdutoDAO extends DerbyDAO implements LoteXProdutoDAOInteface {

	private int id;

	public LoteXProdutoDAO() throws DaoException {
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
		ArrayList<Integer> retorno = new ArrayList<>();

		try{
			ArrayList<Integer> arrayCompare = Main.fachadaPersistence.getArrayLoteXProd();
			for(int i = 0 ; i < arrayCompare.size();  i++){	
				if(arrayCompare.get(i).g

			}catch(Exception e){
				throw new DaoException("\n Erro no retorno da relação entre Lote e Produto, veja:\n "+e.getMessage());
			}

			return null;
		}
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

	}
}
