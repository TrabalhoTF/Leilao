package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO {
  
	int id = 0;

	public static Connection getConnection() throws SQLException {return null;}

	public static boolean consultarTabelas(String sql){return false;}
	
	public int updateCurrentId(String tableName) throws DaoException;
	
	public int getCurrentId() throws DaoException;
}
