package business;

import java.util.ArrayList;

import persistence.DaoException;

public interface FacadePersistenceDao {

	boolean  addUser(Usuario user) throws DaoException;

	boolean addLote(Lote lote) throws DaoException;

	boolean addProd(Produto prod) throws DaoException;

	boolean addLoteXProduto(int idLote, int idProd) throws DaoException;

	boolean createTables() throws DaoException;
	
	boolean reestartDB() throws DaoException;

	boolean executeSQL(String sql) throws DaoException;

	ArrayList<Leilao> getArrayListLeilao() throws DaoException;

	Leilao getLeilaoById(int idLeilao) throws DaoException;

	ArrayList<Usuario> getArrayListUsers() throws DaoException;

	ArrayList<Produto> getArrayListProd() throws DaoException;

	ArrayList<Lote> getArrayListLote() throws DaoException;

	ArrayList<Integer> getArrayListLoteXProd() throws DaoException;

	ArrayList<Integer> getByIdArrayListLoteXProd(int idLotexProd) throws DaoException;;

	Produto getProdById(int idProd);

	Usuario getUserById(String cpfCnpj) throws DaoException;

	Lote getLoteById(int idLote) throws DaoException;
	
	Lance getLanceById(int idLance) throws DaoException;
}