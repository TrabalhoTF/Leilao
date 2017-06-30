package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Leilao;
import business.Usuario;

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
	public Leilao getById(int idLeilao) throws DaoException {
		try {
			for (Leilao i : this.getContentTable()) {
				if (i.getId_leilao() == Integer.valueOf(idLeilao)) {
					return i;
				}
			}
		} catch (Exception e) {
			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: " + e.getMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Leilao> getContentTable() throws DaoException {
		ArrayList<Leilao> arrayReturn = new ArrayList<Leilao>();
		try{
			String sql = "SELECT * FROM LOTEXPRODUTO";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();	
			while(rs.next()){
				arrayReturn.add(new Leilao(rs.getInt("ID_LEILAO"),
								         new LoteDAO().getById(rs.getInt("ID_LOTE")),  
								         (rs.getInt("ATIVO") == 1?true:false), 
								         (rs.getString("TIPO").equals("DEMANDA")?true: false), 
						                  new UsuarioDAO().getById(String.valueOf(rs.getInt("ID_VENDEDOR"))),
						                  rs.getDate("DATA_INICIO").toLocalDate(), 
						                  rs.getDate("DATE_FIM").toLocalDate()));
			}

		}catch(SQLException e){
			throw new DaoException("Não foi possível completar a busca, revisar os parâmetros: "+e.getMessage());
		}
		if(arrayReturn.size() == 0){
			System.out.println("Nenhum registro na tabela LEILAO");
			return null;
		}else{
			return arrayReturn;
		}
	}

	@Override
	public int getCurrentId() throws DaoException {
		return super.updateCurrentId("LEILAO");
	}
}
