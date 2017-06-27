package persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoteXProduto extends DerbyDAO {

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object loteXProduto) throws DaoException {
		ArrayList<Integer> lxp = (ArrayList<Integer>) loteXProduto;
		try{
			String sql = "INSERT INTO LOTEXUSUARIO VALUES(?,?,?)";
			PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);
			ps.executeUpdate();
			ps.setInt(1, lxp.get(1));
			ps.setInt(2, lxp.get(2));
			ps.setInt(3, lxp.get(3));
			ps.close();
		}catch(Exception e){
			throw new DaoException("Não foi possível adicionar a relação entre lote e produto, revisar os parâmetros: "+e.getMessage());
		}
			return true;
		}

	}
