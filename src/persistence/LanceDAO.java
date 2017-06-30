package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

import business.Lance;

public class LanceDAO extends DerbyDAO implements LanceDAOInterface {

	@Override
	public boolean add(Lance lance) throws DaoException {
		try{
			String sql = "INSERT INTO LANCE VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps  = DerbyDAO.getConnection().prepareStatement(sql);
			ps.setInt(1, getCurrentId());
			ps.setString(2, lance.getCpf_cnpj());
			ps.setInt(3,  lance.getIdLeilao());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){		
			throw new DaoException("Não foi possível completar a inserção, revisar o objeto informado: "+e.getMessage());
		}		
		System.out.println("Lance inserido com sucesso!");
		return true;
	}

	@Override
	public Lance getById(int idLance) throws DaoException {
		for(Lance i : this.getContentTable() ){
			if(i.getIDLance() == idLance){
				return i;		
			}			
		}	return null;
	}

	@Override
	public ArrayList<Lance> getContentTable() throws DaoException {
		ArrayList<Lance> arrayReturn = new ArrayList<>();
		try{
			String sql = "SELECT * FROM LANCE";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				arrayReturn.add(new Lance(rs.getInt("ID_LANCE"), 
						rs.getInt("ID_LEILAO"),
						rs.getString("CPF_CNPJ"),
						rs.getDate("DATA_LANCE").toLocalDate(),
						LocalTime.of(rs.getDate("HORA_LANCE").getHours(),
								rs.getDate("HORA_LANCE").getMinutes(),
								rs.getDate("HORA_LANCE").getSeconds()),
						rs.getFloat("VALOR")));
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		if(arrayReturn.size() == 0){
			System.out.println("Nenhum registro na tabela LANCE");
			return null;
		}else{
			return arrayReturn;
		}
	}

	@Override
	public int getCurrentId() throws DaoException {
		return super.updateCurrentId("LANCE");
	}
}
