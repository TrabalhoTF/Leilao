package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.runners.Parameterized.Parameters;


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
		ArrayList<Integer> arrayRetorno = new ArrayList<>();
		System.out.println(((idLotexProd*2)+idLotexProd) );
		try {
			for(int i =((idLotexProd*2)+idLotexProd) , j=((idLotexProd*2)+idLotexProd) ; i < this.getContentTab().size() ; ){
				int comp =this.getContentTab().get(j);
				if (j == this.getContentTab().get(j)) {
					arrayRetorno.add(this.getContentTab().get(j++));
					arrayRetorno.add(this.getContentTab().get(j++));
					arrayRetorno.add(this.getContentTab().get(j++));
					return arrayRetorno;
				}i+=2; j++;
			}
		} catch (Exception e) {
			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: " + e.getMessage());
		}
		return null;
	}

	/**@return
	 * a representacao da tabela LoteXProduto, 
	 * que eh composto por   | IdLotexProd | IdLote | idProd | 
	 * porém, as colunas irao vir na sequencia de um arrayList<Integer>
	 * */	
	@Override
	public ArrayList<Integer> getContentTab() throws DaoException {
		ArrayList<Integer> arrayReturn = new ArrayList<>();
		try{
			String sql = "SELECT * FROM LOTEXPRODUTO";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			int col = 1;		
			while(rs.next()){
				while(col <= 3){
					arrayReturn.add(rs.getInt(col++));
				}col = 1; 
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
			System.out.println(f.getByIdArrayListLoteXProd(3));			
			System.out.println("Result: "+f.executeSQL("SELECT  ID_LOTEXPROD FROM LOTEXPRODUTO"));


		} catch (DaoException w ) {
			// TODO Auto-generated catch block
			w.printStackTrace();
		}
	}
}
