package persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Leilao;

public class LeilaoDAO  extends DerbyDAO implements LeilaoDAOInterface{

	@Override
	public boolean add(Leilao leilao) throws DaoException {
		try{
			String sql = "INSERT INTO LEILAO VALUES(?,?,?,?)";
			PreparedStatement ps  = DerbyDAO.getConnection().prepareStatement(sql);
			ps.setInt(1, getCurrentId());
			ps.setInt(2, (leilao.isAtivo()? 1: 0));
			ps.setString(3, (leilao.isTipo()? "DEMANDA": "OFERTA"));
			ps.setInt(4, Integer.valueOf(leilao.getPrincipal().getCnpj_cpf()));
			ps.setInt(5, leilao.getLote().getId_lote());
			ps.setDate(6, java.sql.Date.valueOf(leilao.getData_inicio()));
			ps.setDate(7, java.sql.Date.valueOf(leilao.getData_fim()));			
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){		
			throw new DaoException("Não foi possível completar a inserção, revisar o objeto informado: "+e.getMessage());
		}		
		System.out.println("Produto inserido com sucesso!");
		return true;
	}

	@Override
	public Leilao getById(String id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Leilao> getContentTable() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurrentId() throws DaoException {
		return super.updateCurrentId("LEILAO");
	}

	
	
}
