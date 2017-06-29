package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Lote;

public class LoteDAO extends DerbyDAO implements LoteDAOInteface {

	@Override
	public boolean add(Lote lote) throws DaoException {
		try {
			String sql = "INSERT INTO LOTE VALUES(?, ?)";
			PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);
			ps.setInt(1, getCurrentId());
			ps.setFloat(2, lote.getPreco());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new DaoException(
					"Não foi possível completar a inserção, revisar o objeto informado: " + e.getMessage());
		}
		System.out.println("Lote inserido com sucesso!");
		return true;
	}

	@Override
	public Lote getById(String idLote) throws DaoException {

		try {
			for (Lote i : this.getContentTable()) {

				if (i.getId_lote() == Integer.valueOf(idLote)) {
					Lote loteRetur = (Lote) i;
					return i;
				}
			}
		} catch (Exception e) {
			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: " + e.getMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Lote> getContentTable() {
		ArrayList<Lote> arrayReturn = new ArrayList<>();
		try {
			String sql = "SELECT * FROM LOTE";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();

			while (rs.next()) {
				arrayReturn.add(new Lote(rs.getInt("ID_LOTE"), rs.getFloat("PRECO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		if (arrayReturn.size() == 0) {
			System.out.println("Nenhum registro na tabela LOTE");
			return null;
		} else {
			return arrayReturn;
		}
	}

	@Override
	public int getCurrentId() throws DaoException {
		return super.updateCurrentId("LOTE");
	}

	public static void main(String[] args) throws DaoException {
		FacadePersistence s = new FacadePersistence();
		s.executeSQL("select nome from usuario");
	}

}