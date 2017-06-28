package persistence;

import java.util.ArrayList;

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

	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> getArrayUsers() throws DaoException{		
		ArrayList<Usuario> usr = new ArrayList<>();
		int cont = 0;
		for(Usuario usr1: this.usuarioDAO.getContentTable()){
			usr.add(usr1);
			cont++;
		}		
		return usr;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produto> getArrayProd() throws DaoException{
		ArrayList<Produto> prod = new ArrayList<>();
		int cont = 0;
		for(Produto pr: this.produtoDAO.getContentTable()){
			prod.add(pr);
			cont++;
		}		
		return prod;		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Lote> getArrayListLote() throws DaoException{
		ArrayList<Lote> lote = new ArrayList<>();
		for(int i = 0 ; i < loteDAO.getContentTable().size() ; i++){
			lote.add(this.loteDAO.getContentTable().get(i));
		}		
		return lote;		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getArrayListLoteXProd() throws DaoException{
		ArrayList<Integer> lotexprod = new ArrayList<>();
		int cont = 0;
		for(int lp: this.lotexprod.getContentTab()){
			lotexprod.add(lp);
			cont++;
		}		
		return lotexprod;		
	}

}
