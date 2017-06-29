package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Application;
import business.LeilaoException;

/**
 * 
 * @author João França
 */
public class DerbyDAO implements DAO {

	private String table = "";

	private void Connection() throws DaoException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException ex) {
			throw new DaoException("Não foi possível conectar ao Derby, revisar erros: " + ex.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {
		// derbyDB sera o nome do diretorio criado localmente
		return DriverManager.getConnection("jdbc:derby:derbyDB");
	}

	public boolean executeSQL(String sql) throws DaoException {
		try {
			sql = sql.toUpperCase();
			PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);
			if (sql.contains("CREATE") || sql.contains("UPDATE") || sql.contains("INSERT") || sql.contains("DROP")
					|| sql.contains("DELETE") || sql.contains("ALTER")) {
				ps.execute();
				System.out.println("Comando executado com sucesso!");
				ps.close();
			} else {
				ps.executeQuery();
				ResultSet rs = ps.getResultSet();
				int row = 0;
				while (rs.next()) {
					System.out.println(rs.getString(1));
					row++;
				}
				System.out.println("Sua query retornou " + row + " tupla(s).");
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			throw new DaoException("Teu SQL ta com o seguinte erro: " + e.getMessage());
		}
		return true;
	}

	public boolean reestartDb() throws DaoException {
		try {
			PreparedStatement ps = null;
			ArrayList<String> sql = new ArrayList<>();
			sql.add("DELETE FROM LOTEXPRODUTO");
			sql.add("DELETE FROM LANCE");
			sql.add("DELETE FROM USUARIO");
			sql.add("DELETE FROM LOTE");
			sql.add("DELETE FROM LEILAO");
			sql.add("DELETE FROM PRODUTO");
			int a = 0;
			for (String s : sql) {
				ps = DerbyDAO.getConnection().prepareStatement(sql.get(a++));
				ps.execute();
			}
			ps.execute();
			System.out.println("Banco reiciniado");
			ps.close();
		} catch (Exception e) {
			throw new DaoException("Teu SQL ta com o seguinte erro: " + e.getMessage());
		}
		return true;
	}

	public boolean createTables() throws DaoException {
		try {
			String sql = "CREATE TABLE LOTE(ID_LOTE INT NOT NULL PRIMARY KEY,PRECO NUMERIC(10,2) NOT NULL)";
			PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute() ? "Tabela LOTE criada!" : "Erro ao criar tabela LOTE!"));

			sql = "CREATE TABLE PRODUTO(ID_PRODUTO INT NOT NULL PRIMARY KEY, CATEGORIA VARCHAR(20) NOT NULL, DESCRICAO_SIMPLES VARCHAR(10) NOT NULL,DESCRICAO_COMPLETA VARCHAR(40))";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute() ? "Tabela PRODUTO criada!" : "Erro ao criar tabela PRODUTO!"));

			sql = "CREATE TABLE LOTEXPRODUTO(ID_LOTEXPROD INT NOT NULL PRIMARY KEY,ID_LOTE INT NOT NULL,ID_PRODUTO INT NOT NULL,CONSTRAINT FK_LOTE FOREIGN KEY (ID_LOTE) REFERENCES LOTE(ID_LOTE),CONSTRAINT FK_PROD FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTO(ID_PRODUTO))";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute() ? "Tabela LOTEXPRODUTO criada!" : "Erro ao criar tabela LOTEXPRODUTO!"));

			sql = "CREATE TABLE LEILAO(ID_LEILAO INT NOT NULL PRIMARY KEY,ATIVO INT NOT NULL CHECK(ATIVO IN(1,0)),VALOR_INICIAl_LOTE INT NOT NULL,TIPO VARCHAR(10) NOT NULL CHECK(TIPO IN('DEMANDA', 'OFERTA')),ID_VENDEDOR_COMPRADOR INT NOT NULL,ID_LOTE INT NOT NULL,DATA_INICIO DATE NOT NULL,DATE_FIM DATE NOT NULL,CONSTRAINT FK_ID_LOTE FOREIGN KEY(ID_LOTE) REFERENCES LOTE(ID_LOTE))";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute() ? "Tabela LEILAO criada!" : "Erro ao criar tabela LEILAO!"));

			sql = "CREATE TABLE USUARIO(CPF_CNPJ VARCHAR(30) NOT NULL PRIMARY KEY,NOME VARCHAR(20) NOT NULL,EMAIL VARCHAR(30) NOT NULL)";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute() ? "Tabela USUARIO criada!" : "Erro ao criar tabela USUARIO!"));

			sql = "CREATE TABLE LANCE(ID_LANCE INT NOT NULL PRIMARY KEY,CPF_CNPJ VARCHAR(30) NOT NULL,ID_LEILAO INT NOT NULL,CONSTRAINT FK_IDUSER FOREIGN KEY (CPF_CNPJ) REFERENCES USUARIO(CPF_CNPJ),CONSTRAINT FK_ID_LEILAO FOREIGN KEY (ID_LEILAO) REFERENCES LEILAO(ID_LEILAO))";
			ps = DerbyDAO.getConnection().prepareStatement(sql);
			System.out.println((ps.execute() ? "Tabela LANCE criada!" : "Erro ao criar tabela LANCE!"));

			ps.close();
		} catch (SQLException e) {
			throw new DaoException("Não foi possível criar as tabelas, revisar os erros: " + e.getMessage());
		}
		return true;
	}

	@Override
	public int updateCurrentId(String tableName) throws DaoException {
		int num = 0;
		this.table = tableName;
		try {
			String sql = "SELECT * FROM " + this.table;

			PreparedStatement ps = DerbyDAO.getConnection().prepareStatement(sql);
			ps.executeQuery();

			ResultSet rs = ps.getResultSet();

			while (rs.next()) {
				num++;
				System.out.println(sql);
			}

			ps.close();
			rs.close();
		} catch (Exception e) {
			num = 0;
			throw new DaoException("\n Erro ao consultar o id corrente, verificar: \n" + e.getCause());
		}
		return num;
	}

	@Override
	public int getCurrentId() throws DaoException {
		return updateCurrentId(this.table);
	}

	public static void main(String[] args) throws DaoException, LeilaoException {		

	}

}