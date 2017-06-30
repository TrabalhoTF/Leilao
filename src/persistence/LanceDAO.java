package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Categoria;
import business.Lance;
import business.Produto;

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

     

	Lance  l = new Lance(idLance, idLeilao, cpf_cnpj, data, hora, valor);
			//			
			//			CREATE TABLE LANCE(
			//					ID_LANCE INT NOT NULL PRIMARY KEY,
			//					CPF_CNPJ VARCHAR(30) NOT NULL,
			//					ID_LEILAO INT NOT NULL,
			//					CONSTRAINT FK_IDUSER FOREIGN KEY (CPF_CNPJ) REFERENCES USUARIO(CPF_CNPJ),
			//					CONSTRAINT FK_ID_LEILAO FOREIGN KEY (ID_LEILAO) REFERENCES LEILAO(ID_LEILAO));

			//partir daqui, falta colocar a coluna data e hora na tabela lance
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
															rs.getString("CPF_CNPJ"),
															rs.getInt("ID_LEILAO")));
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
