package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import business.Categoria;
import business.LeilaoException;
import business.Lote;
import business.Produto;
import business.Usuario;

public class LoteXProdutoDAO extends DerbyDAO implements LoteXProdutoDAOInterface {


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
	public ArrayList<Integer> getById(int idLotexProd) throws DaoException {
		return null;
		//		try {
		//			for (Lote i : this.getContentTable()) {
		//
		//				if (i.getId_lote() == Integer.valueOf(idLote)) {
		//					Lote loteRetur = (Lote) i;
		//					return i;
		//				}
		//			}
		//		} catch (Exception e) {
		//			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: " + e.getMessage());
		//		}
		//		return null;
	}

	@Override
	public ArrayList<Integer> getContentTab() throws DaoException {
		ArrayList<Integer> arrayReturn = new ArrayList<>();
		try{
			String sql = "SELECT * FROM LOTEXPRODUTO";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			int  i =1;
			
			while(rs.next()){
				while(i < i+2){
					arrayReturn.add(rs.getInt(i));
					i++;
				}i = 1;
			}
			
		}catch(SQLException e){
			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: "+e.getMessage());
		}
		if(arrayReturn.size() == 0){
			System.out.println("Nenhum registro na tabela LOTEXPRODUTO");
			return null;
		}else{
			return arrayReturn;
		}
	}

	@Override
	public int getCurrentId() throws DaoException {
		return super.updateCurrentId("LOTEXPRODUTO");
	}

	public static void main(String[] args) {
		try {
			FacadePersistence f = new  FacadePersistence();
			//		app.getPersistenceFac().addProd(new Produto(Categoria.INFORMATICA, "bom", "barato"));
			//	System.out.println(app.getPersistenceFac().getArrayListProd().get(0).getId_produto());
			//app.getPersistenceFac().addLoteXProduto(0, 0);

			//System.out.println(app.getPersistenceFac().getArrayListLote().get(0).getPreco());
			//System.out.println(app.getPersistenceFac().executeSQL("select * from lotexproduto"));
			System.out.println(f.getArrayListLoteXProd().get(0));
			//			ArrayList<Integer> e = app.getPersistenceFac().getArrayListLoteXProd();
			////			
			//			for(int i : e){
			//				System.out.println(i);
			//			}

		} catch (DaoException w ) {
			// TODO Auto-generated catch block
			w.printStackTrace();
		}
	}
}
