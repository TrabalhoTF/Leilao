package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Business.Usuario;

/**
 *
 * @author Jo�o Fran�a
 */
abstract class DerbyDAO implements DAO{    

	private void Connection(){
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException ex) {
		}
	}    

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

	public boolean addUser(Usuario usr){	

		System.out.println("** inserido com sucesso!");
		return true;
	}

	public Object getById(String id){
		Usuario objRetur = null;		
		return objRetur;
	}

	public ArrayList<Object> getContentTable(){
		ArrayList<Object> arrayReturn = new ArrayList<>();
		try{
			String sql = "SELECT * FROM ";

		}catch(Exception e){}
		return arrayReturn;
	}

	public static boolean createTables(){
		try{
			String sql = "CREATE TABLE LOTE(ID_LOTE INT NOT NULL PRIMARY KEY)";
			PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);			
			System.out.println((ps.execute()? "Tabela LOTE criada!": "Erro ao criar tabela LOTE!"));

			sql = "CREATE TABLE PRODUTO(ID_PRODUTO INT NOT NULL PRIMARY KEY,DESCRICAO_SIMPLES VARCHAR(10) NOT NULL,DESCRICAO_COMPLETA VARCHAR(40)CATEGORIA VARCHAR(10) NOT NULL)";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute()? "Tabela PRODUTO criada!": "Erro ao criar tabela PRODUTO!"));

			sql = "CREATE TABLE LOTEXPRODUTO(ID_LOTEXPROD INT NOT NULL PRIMARY KEY,ID_LOTE INT NOT NULL,ID_PRODUTO INT NOT NULL,CONSTRAINT FK_LOTE FOREIGN KEY (ID_LOTE) REFERENCES LOTE(ID_LOTE),CONSTRAINT FK_PROD FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTO(ID_PRODUTO))";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute()? "Tabela LOTEXPRODUTO criada!": "Erro ao criar tabela LOTEXPRODUTO!"));

			sql = "CREATE TABLE LEILAO(ID_LEILAO INT NOT NULL PRIMARY KEY,ATIVO INT NOT NULL CHECK(ATIVO IN(1,0)),VALOR_INICIAl_LOTE INT NOT NULL,TIPO VARCHAR(10) NOT NULL CHECK(TIPO IN('DEMANDA', 'OFERTA')),ID_VENDEDOR_COMPRADOR INT NOT NULL,ID_LOTE INT NOT NULL,DATA_INICIO DATE NOT NULL,DATE_FIM DATE NOT NULL,CONSTRAINT FK_ID_LOTE FOREIGN KEY(ID_LOTE) REFERENCES LOTE(ID_LOTE))";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute()? "Tabela LEILAO criada!": "Erro ao criar tabela LEILAO!"));

			sql = "CREATE TABLE USUARIO(CPF_CNPJ INT NOT NULL PRIMARY KEY,NOME VARCHAR(20) NOT NULL,EMAIL VARCHAR(30) NOT NULL)";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute()? "Tabela USUARIO criada!": "Erro ao criar tabela USUARIO!"));

			sql = "CREATE TABLE LANCE(ID_LANCE INT NOT NULL PRIMARY KEY,CPF_CNPJ INT NOT NULL,ID_LEILAO INT NOT NULL,CONSTRAINT FK_IDUSER FOREIGN KEY (CPF_CNPJ) REFERENCES USUARIO(CPF_CNPJ),CONSTRAINT FK_ID_LEILAO FOREIGN KEY (ID_LEILAO) REFERENCES LEILAO(ID_LEILAO))";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute()? "Tabela LANCE criada!": "Erro ao criar tabela LANCE!"));
			ps.close();
		}catch(SQLException e ){
			e.printStackTrace(); return false;
		}
		return true;
	}


	public static void main(String[] args) throws SQLException {
		DerbyDAO.consultarTabelas("SELECT * FROM LOTE");
	}  
}