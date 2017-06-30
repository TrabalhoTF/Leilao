package persistence;

import java.util.ArrayList;

import business.Lance;
import business.Leilao;
import business.Lote;
import business.Produto;
import business.Usuario;
import sun.security.jca.GetInstance;

public class FacadePersistence {


	private LoteDAO loteDAO = new LoteDAO();
	private DerbyDAO derbyDAO = new DerbyDAO();
	private LoteXProdutoDAO lotexprod = new LoteXProdutoDAO();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private LeilaoDAO leilaoDAO = new LeilaoDAO();
	private LanceDAO lanceDAO = new LanceDAO();

	public FacadePersistence() throws DaoException{
		this.lotexprod = new LoteXProdutoDAO();
	}

	public boolean  addUser(Usuario user) throws DaoException{
		return this.usuarioDAO.add(user);
	}

	public boolean addLote(Lote lote) throws DaoException{
		return this.loteDAO.add(lote);
	}

	public boolean addProd(Produto prod) throws DaoException{
		return this.produtoDAO.add(prod);
	}

	public boolean addLoteXProduto(int idLote, int idProd) throws DaoException{
		this.lotexprod.addLoteXProd(idLote, idProd);
		return true;
	}

	public boolean createTables() throws DaoException{
		return this.derbyDAO.createTables();
	}

	public boolean reestartDB() throws DaoException{
		return this.derbyDAO.reestartDb();
	}

	public boolean executeSQL(String sql) throws DaoException{
		return this.derbyDAO.executeSQL(sql);
	}

	public ArrayList<Leilao> getArrayListLeilao() throws DaoException{
		return this.leilaoDAO.getContentTable();
	}
	
	public Leilao getLeilaoById(int idLeilao) throws DaoException{
		return this.leilaoDAO.getById(idLeilao);
	}	
	
	public ArrayList<Usuario> getArrayListUsers() throws DaoException{		
		return this.usuarioDAO.getContentTable();
	}

	public ArrayList<Produto> getArrayListProd() throws DaoException{
		return this.produtoDAO.getContentTable();
	}

	public ArrayList<Lote> getArrayListLote() throws DaoException{
		return this.loteDAO.getContentTable();		
	}

	public ArrayList<Integer> getArrayListLoteXProd() throws DaoException{
		return this.lotexprod.getContentTab();
	}

	public ArrayList<Integer> getByIdArrayListLoteXProd(int idLotexProd) throws DaoException{
		return this.lotexprod.getById(idLotexProd);
	}
	
		
	public Produto getProdById(int idProd){
		return this.produtoDAO.getById(idProd);
	}
	
	public Usuario getUserById(String cpfCnpj) throws DaoException{
		return this.usuarioDAO.getById(cpfCnpj);
	}
	
	public Lote getLoteById(int idLote) throws DaoException{
		return this.loteDAO.getById(idLote);
	}
	
	public Lance getLanceById(int idLance) throws DaoException{
		return this.lanceDAO.getById(idLance);	
	}

}
