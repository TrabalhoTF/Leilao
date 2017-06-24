package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO {
  

	public static Connection getConnection() throws SQLException {
		//derbyDB sera o nome do diretorio criado localmente
		return DriverManager.getConnection("jdbc:derby:derbyDB");
	}

	public static boolean consultarTabelas(String sql){		
		if(sql.contains("update") || sql.contains("insert") || sql.contains("drop") || sql.contains("delete")){
			System.out.println("Permitido somente consultas!");
			return false;
		}
		else{

			try{
				PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);
				ps.executeQuery();
				ResultSet rs = ps.getResultSet();
				int row = 0;
				while(rs.next()){
					System.out.println((row++)+":"+rs.getRow());
				}			
				rs.close();
				ps.close();	
			}catch(SQLException e ){
				e.printStackTrace();
				return false;
			}		
			return true;
		}
	}

	public boolean addUser(Object usr);

	public Object getById(String id);

	public ArrayList<Object> getContentTable();
}
