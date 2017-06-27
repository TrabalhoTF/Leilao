package persistence;

import java.util.ArrayList;

import business.Lote;
import business.Produto;
import business.Usuario;

public class SingletonPersistence {
	
	private static SingletonPersistence instance = new SingletonPersistence();
	
	private LoteDAO loteDAO;
	private DerbyDAO derbyDAO;
	private LoteXProduto lotexprod;
	private ProdutoDAO produtoDAO;
	private UsuarioDAO usuarioDAO;
	
	public SingletonPersistence(){
		this.loteDAO = new LoteDAO();
		this.derbyDAO = new DerbyDAO();
		this.lotexprod = new LoteXProduto();
		this.produtoDAO = new ProdutoDAO();
		this.usuarioDAO = new UsuarioDAO();	
	}
	
	public static synchronized  SingletonPersistence getInstance(){
		return instance;
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
	
	public boolean addLoteXUser(ArrayList<Integer> loteXprod) throws DaoException{
		this.lotexprod.add(loteXprod);
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

	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> getArrayUsers() throws DaoException{		
		ArrayList<Usuario> usr = new ArrayList<>();
		int cont = 0;
		for(Object usr1: this.usuarioDAO.getContentTable()){
			usr.add(((ArrayList<Usuario>)usr1).get(cont));
			cont++;
		}		
		return usr;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Produto> getArrayProd() throws DaoException{
		ArrayList<Produto> prod = new ArrayList<>();
		int cont = 0;
		for(Object pr: this.produtoDAO.getContentTable()){
			prod.add(((ArrayList<Produto>)pr).get(cont));
			cont++;
		}		
		return prod;		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Lote> getArrayLote() throws DaoException{
		ArrayList<Lote> lote = new ArrayList<>();
		int cont = 0;
		for(Object lt: this.loteDAO.getContentTable()){
			lote.add(((ArrayList<Lote>)lt).get(cont));
			cont++;
		}		
		return lote;		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getArrayLoteXProd() throws DaoException{
		ArrayList<Integer> lotexprod = new ArrayList<>();
		int cont = 0;
		for(Object lp: this.lotexprod.getContentTable()){
			lotexprod.add(((ArrayList<Integer>)lp).get(cont));
			cont++;
		}		
		return lotexprod;		
	}

}
